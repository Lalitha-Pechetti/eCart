package com.lalli.eCart.exception;

import java.util.Date;

public class AppErrorDetails {
	private Date timestamp;
	private String message;
	private String details;
	private String cause;
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	@Override
	public String toString() {
		return "AppErrorDetails [timestamp=" + timestamp + ", message=" + message + ", details=" + details + ", cause="
				+ cause + "]";
	}
	
	
	
	
}
