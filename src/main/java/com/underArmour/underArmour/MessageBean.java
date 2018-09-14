package com.underArmour.underArmour;

import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class MessageBean {
	
    private long rowID;
	
	private String username;
	
	private String text;
	
    public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private int timeout;
    
    private Date expiration_date;
	
	public Date getExpiration_date() {
		return expiration_date;
	}

	public void setExpiration_date(Date expiration_date) {
		this.expiration_date = expiration_date;
	}

	public long getRowID() {
		return rowID;
	}

	public void setRowID(long rowID) {
		this.rowID = rowID;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	

	
	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}



}
