package com.elbon.restful.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timestamp;
	
	private String message;
	
	private int status;
	
	private String description;

	public ExceptionResponse(Date timestamp, String message, int status, String description) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
		this.description = description;
	}

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
