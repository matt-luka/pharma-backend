package com.pharma.PharmaApp.dto.user;

public class LoginReturnDTO {

	private String token;
	private String status;
	
	public LoginReturnDTO(String token, String status) {
		this.status = status;
		this.token = token;
	}
	
	public String getToken() {
		return this.token;
	}
	
	public void setToken(String token) {
		this.token = token;
		return;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
		return;
	}
	
}
