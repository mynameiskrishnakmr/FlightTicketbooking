package com.ticketbooking.booking.model;

import java.time.LocalDateTime;

public class ErrorResponseMessage{
	
private int statusCode;
private String message;
private Exception e;
private LocalDateTime time;

public ErrorResponseMessage() {
    this.time = LocalDateTime.now();    
}

public ErrorResponseMessage(int statusCode, String message, Exception e) {
    this();
    this.statusCode = statusCode;
    this.message = message;
    this.e = e;
}


public int getStatusCode() {
    return this.statusCode;
}

public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
}

public String getMessage() {
    return this.message;
}

public void setMessage(String message) {
    this.message = message;
}

public Exception getE() {
    return this.e;
}

public void setE(Exception e) {
    this.e = e;
}

public LocalDateTime getTime() {
    return this.time;
}

public void setTime(LocalDateTime time) {
    this.time = time;
}

@Override
public String toString() {
    return "{" +
        " statusCode='" + getStatusCode() + "'" +
        ", message='" + getMessage() + "'" +
        ", e='" + getE() + "'" +
        ", time='" + getTime() + "'" +
        "}";
}


}
