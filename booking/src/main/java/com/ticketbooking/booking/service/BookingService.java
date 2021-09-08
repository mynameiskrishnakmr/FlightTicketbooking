package com.ticketbooking.booking.service;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ticketbooking.booking.entity.BookingDetails;
import com.ticketbooking.booking.entity.Passenger;
import com.ticketbooking.booking.entity.User;
import com.ticketbooking.booking.exception.CancellationNotallowedException;
import com.ticketbooking.booking.exception.NotEnoughSeatsException;
import com.ticketbooking.booking.exception.TicketDetailsNotFoundException;
import com.ticketbooking.booking.model.BookingHistory;
import com.ticketbooking.booking.model.Coupon;
import com.ticketbooking.booking.model.Flight;
import com.ticketbooking.booking.model.PassengerDetails;
import com.ticketbooking.booking.model.Ticket;
import com.ticketbooking.booking.repository.BookingRepository;
import com.ticketbooking.booking.repository.PassengerRepository;
import com.ticketbooking.booking.repository.UserRepository;

@Service
public class BookingService {

	@Autowired
	private UserRepository userrepo;

	@Autowired
	private BookingRepository bookRepo;

	@Autowired
	private PassengerRepository passengerrepo;

	@Autowired
	private RestTemplate restTemplate;

	public Ticket bookTicket(List<Passenger> passengers, int flightid, String userId,String  discountCoupon)
			throws SQLException, NotEnoughSeatsException {

		final String BOOKED_STATUS = "Booked";
		 String COUPON_APPLIED_STATUS = "Coupon code is Invalid";

		ResponseEntity<Flight> res = restTemplate.exchange("http://FLIGHT-SERVICE/flight/" + flightid, HttpMethod.GET,
				null, new ParameterizedTypeReference<Flight>() {
				});
		Optional<User> user = userrepo.findById(userId);

		System.out.println("after flight rest call" + res.getBody());
		User Userdata = user.get();
		Flight flightdata = res.getBody();
		if (flightdata != null) {

			int noOfPassengers = passengers.size();
			int seats = flightdata.getSeats();
			int bookedSeats = flightdata.getSeatsBooked();

			if ((seats - bookedSeats) > noOfPassengers) {
				seats = seats - noOfPassengers;
				bookedSeats = bookedSeats + noOfPassengers;
				flightdata.setSeats(seats);
				flightdata.setSeatsBooked(bookedSeats);
			} else {
				throw new NotEnoughSeatsException();
			}

			int flightId = flightdata.getFlightId();
			int airlineId = flightdata.getAirline().getAirlineId();
			double price = noOfPassengers * flightdata.getPrice();
			BookingDetails bookTicket = new BookingDetails(flightId, Userdata, BOOKED_STATUS, price, passengers);
			System.out.println("before setting booking details" + bookTicket.toString());
			bookRepo.save(bookTicket);
			
			Set<PassengerDetails> passengersModel = new HashSet<PassengerDetails>();
			passengers.parallelStream().forEach(passenger -> {
				passenger.setBookings(bookTicket);
				passengerrepo.save(passenger);
				PassengerDetails passDet = new PassengerDetails(passenger.getName(), passenger.getAge(),
						passenger.getGender());
				passengersModel.add(passDet);
			});

			HttpEntity<Flight> requestEntity = new HttpEntity<>(flightdata);
			ResponseEntity<Flight> res1 = restTemplate.exchange(
					"http://FLIGHT-SERVICE/airline/" + airlineId + "/flight/" + flightId, HttpMethod.PUT, requestEntity,
					new ParameterizedTypeReference<Flight>() {
					});
			
			/*ResponseEntity<Coupon> couponAPI = restTemplate.exchange(
					"http://ADMIN-SERVICE/coupon/" + discountCoupon, HttpMethod.GET, requestEntity,
					new ParameterizedTypeReference<Coupon>() {
					});
			
					/*
					 * if(couponAPI.getBody()!=null) { COUPON_APPLIED_STATUS=
					 * "Discount Coupon Applied"; price = price -
					 * noOfPassengers*(couponAPI.getBody().getDiscountPrice()); }
					 */

			System.out.println("after updating flight" + res1.getBody());
			
			return new Ticket(Userdata.getUserId(), flightdata.getFlightName(), flightdata.getDate(),flightdata.getDateTime(),flightdata.getAirlineName(), bookTicket.getId(), passengersModel,BOOKED_STATUS,price , COUPON_APPLIED_STATUS);

		} else {
			throw new NullPointerException("Flight Details not found");
		}
	}

	public Ticket getTicketByPNR( int pnr) throws SQLException, NoSuchElementException,NullPointerException, TicketDetailsNotFoundException {
		Optional<BookingDetails> bookingDetailsOptional = bookRepo.findById(pnr);

		if (bookingDetailsOptional.isPresent()) {
			BookingDetails bookingDetails = bookingDetailsOptional.get();
			String userId = bookingDetails.getUser().getUserId();
			int flightid = bookingDetails.getFlight();
			ResponseEntity<Flight> res = restTemplate.exchange("http://FLIGHT-SERVICE/flight/" + flightid,
					HttpMethod.GET, null, new ParameterizedTypeReference<Flight>() {
					});
			if (res.getBody() != null) {
				String flightName = res.getBody().getFlightName();
				String airlineName = res.getBody().getAirlineName();
				LocalDate flightDate = res.getBody().getDate();
				LocalTime flightTime  = res.getBody().getDateTime();
				List<Passenger> passengers = bookingDetails.getPassengers();
				Set<PassengerDetails> passengersModel = new HashSet<PassengerDetails>();
				passengers.parallelStream().forEach(passenger -> {
					PassengerDetails passDet = new PassengerDetails(passenger.getName(), passenger.getAge(),
							passenger.getGender());
					passengersModel.add(passDet);
				});

				Ticket ticket = new Ticket(userId, flightName, flightDate,flightTime, airlineName,pnr, passengersModel,bookingDetails.getStatus(), bookingDetails.getPrice());
				System.out.println("userId" + userId + " FlightName:" + flightName + " Date :" + flightDate);
				return ticket;
			} else {
				throw new NullPointerException("Flight Details not found");
			}
		}

		throw new TicketDetailsNotFoundException("Ticket details not found , Please enter a valid PNR");
	}

	public List<BookingHistory> getTicketByEmail(String emailId)
			throws SQLException, TicketDetailsNotFoundException, NullPointerException {

		List<BookingDetails> bookingDetails = bookRepo.findByEmail(emailId);
		System.out.println("---------booking details in get ticket by email" + bookingDetails);

		List<BookingHistory> bookingHistories = new ArrayList<>();
		if (bookingDetails.size() > 0) {

			bookingDetails.parallelStream().forEach(detail -> {

				int flightid = detail.getFlight();
				ResponseEntity<Flight> res = restTemplate.exchange("http://FLIGHT-SERVICE/flight/" + flightid,
						HttpMethod.GET, null, new ParameterizedTypeReference<Flight>() {
						});

				Flight flight = res.getBody();
				if (flight != null) {
					String airlineName = flight.getAirlineName();
					String flightFrom = flight.getFrom();
					String flightTo = flight.getTo();
					LocalDate flightDate = flight.getDate();
					LocalTime flightTime = flight.getDateTime();
					int noOfPassengers = detail.getPassengers().size();
					String userId = detail.getUser().getUserId();
					List<PassengerDetails> passengersModel = new ArrayList<>();
					List<Passenger> passengers = detail.getPassengers();

					passengers.parallelStream().forEach(passenger -> {
						PassengerDetails passDet = new PassengerDetails(passenger.getName(), passenger.getAge(),
								passenger.getGender());
						passengersModel.add(passDet);
					});

					BookingHistory bookingHistory = new BookingHistory(userId, emailId, airlineName, flightFrom,
							flightTo, flightDate, flightTime, noOfPassengers, passengersModel);
					bookingHistories.add(bookingHistory);
				} else {
					throw new NullPointerException("Flight Details not found");
				}
			});

			return bookingHistories;

		}
		throw new TicketDetailsNotFoundException("Ticket details not found , Please enter a valid emai");
	}

	public void deleteTicketByPNR(String userid, int pnr) throws CancellationNotallowedException, TicketDetailsNotFoundException {

		Optional<BookingDetails> bookingDetailsOptional = bookRepo.findByIdAndStatus(userid ,pnr);
		final long DAY_IN_SEC = 24 * 60 * 60 * 1000;
		final String CANCEL_STATUS = "Cancelled";

		if (bookingDetailsOptional.isPresent()) {

			BookingDetails bookingDetails = bookingDetailsOptional.get();
			int flightId = bookingDetails.getFlight();
			ResponseEntity<Flight> res = restTemplate.exchange("http://FLIGHT-SERVICE/flight/" + flightId,
					HttpMethod.GET, null, new ParameterizedTypeReference<Flight>() {
					});
			Flight flightdata = res.getBody();
			if (flightdata != null) {
				int airlineId = flightdata.getAirline().getAirlineId();

				String ticketDateTimeStr = flightdata.getDate().toString().concat(" ")
						.concat(flightdata.getDateTime().toString());
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				LocalDateTime ticketDateTime = LocalDateTime.parse(ticketDateTimeStr, formatter);
				long timeInMillis = ticketDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
				System.out.println(timeInMillis - System.currentTimeMillis() > DAY_IN_SEC);

				if (timeInMillis - System.currentTimeMillis() > DAY_IN_SEC) {

					int seats = flightdata.getSeats();
					int noOfPassengers = bookingDetails.getPassengers().size();
					int bookedSeats = flightdata.getSeatsBooked();
					seats = seats + noOfPassengers;
					bookedSeats = bookedSeats - noOfPassengers;

					flightdata.setSeats(seats);
					flightdata.setSeatsBooked(bookedSeats);
					bookingDetails.setStatus(CANCEL_STATUS);

					bookRepo.save(bookingDetails);

					HttpEntity<Flight> requestEntity = new HttpEntity<>(flightdata);
					ResponseEntity<Flight> res1 = restTemplate.exchange(
							"http://FLIGHT-SERVICE/airline/" + airlineId + "/flight/" + flightId, HttpMethod.PUT,
							requestEntity, new ParameterizedTypeReference<Flight>() {
							});
					System.out.println("after updating flight" + res1.getBody());

				}

				else {
					throw new CancellationNotallowedException(
							"Cannot cancel ticket as flight's departure time is less that 24 hours");
				}

			} else {

				throw new NullPointerException("Flight Details not found");
			}

		} else {
			throw new TicketDetailsNotFoundException("Ticket details not found , Please enter a valid PNR");
		}
	}

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
