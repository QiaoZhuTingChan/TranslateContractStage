package com.jyd.bms.dto;

import java.io.Serializable;

public class PublicMessageDTO implements Serializable{
	private String title;
	private String message;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
