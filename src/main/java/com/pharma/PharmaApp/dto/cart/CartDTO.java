package com.pharma.PharmaApp.dto.cart;

import javax.validation.constraints.NotNull;

public class CartDTO {
	
	private Integer id;
	private @NotNull Integer medicationID;
	private @NotNull int quantity;
	
	public CartDTO() {
		
	}
	
	public Integer getID() {
		return this.id;
	}
	
	public void setID(Integer id) {
		this.id = id;
		return;
	}
	
	public Integer getMedID() {
		return this.medicationID;
	}
	
	public void setMedID(Integer medID) {
		this.medicationID = medID;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void setQuantity(int x) {
		this.quantity = x;
		return;
	}
	
	@Override
	public String toString() {
		return "Cart {id=" + id + " medication=" + medicationID + " quantity=" + quantity + "}";
	}

}
