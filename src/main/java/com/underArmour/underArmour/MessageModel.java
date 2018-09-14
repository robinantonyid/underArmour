package com.underArmour.underArmour;

import java.sql.Timestamp;
import java.time.ZonedDateTime;

public class MessageModel {
	
	
    private long id;
	
	private String username;
	
	private String message;
	
	private Timestamp creationTime;
	
	private Timestamp expirationTime;
	
	private int timeout;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Timestamp creationTime) {
		this.creationTime = creationTime;
	}

	public Timestamp getExpirationTime() {
		return expirationTime;
	}

	public void setExpirationTime(Timestamp expiration_time) {
		this.expirationTime = expiration_time;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
  
}
