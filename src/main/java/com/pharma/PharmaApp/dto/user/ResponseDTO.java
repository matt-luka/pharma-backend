package com.pharma.PharmaApp.dto.user;

public class ResponseDTO {

	private String status;
	private String msg;
	
	public ResponseDTO(String status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	
	
	public String getMsg() {
		return this.msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
		return;
	}
	
	public String getStat() {
		return this.status;
	}
	
	public void setStat(String status) {
		this.status = status;
		return;
	}
}
