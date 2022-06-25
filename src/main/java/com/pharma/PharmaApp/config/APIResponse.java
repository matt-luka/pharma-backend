package com.pharma.PharmaApp.config;

import java.time.LocalDateTime;

public class APIResponse {
	private final boolean success;
	private final String message;
	
	public APIResponse(boolean status, String message) {
		this.success = status;
		this.message = message;
	}
	
	public boolean status() {
		return this.success;
	}
	
	public String getMessage() {
		return this.message;
	}

	public String getTime() {
		return LocalDateTime.now().toString();
	}
	
}
