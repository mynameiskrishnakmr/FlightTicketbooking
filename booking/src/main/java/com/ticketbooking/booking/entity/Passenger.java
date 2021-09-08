package com.ticketbooking.booking.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



	@Entity
	public class Passenger {
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "PASSENGER_ID")
		private int id;
		
		private String name;
		
		private String age;
		
		private String gender;
		
		@ManyToOne
		@JoinColumn(name = "pnr")
		private BookingDetails bookings;
		

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public BookingDetails getBookings() {
			return bookings;
		}

		public void setBookings(BookingDetails bookings) {
			this.bookings = bookings;
		}

		@Override
		public String toString() {
			return "Passenger [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender ;
		}
		
		



}
