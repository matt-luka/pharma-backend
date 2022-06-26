package com.pharma.PharmaApp.dto.cart;

import java.util.List;

public class TotalCartDTO {

	private List<ItemDTO> items;
	private double price;
	
	public TotalCartDTO(List<ItemDTO> items, double price) {
		this.items = items;
		this.price = price;
	}
	
	public List<ItemDTO> getItems(){
		return this.items;
	}
	
	public void setItems(List<ItemDTO> items) {
		this.items = items;
		return;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
		return;
	}
	
}
