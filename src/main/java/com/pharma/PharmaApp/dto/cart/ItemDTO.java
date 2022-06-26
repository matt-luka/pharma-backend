package com.pharma.PharmaApp.dto.cart;

import javax.validation.constraints.NotNull;

import com.pharma.PharmaApp.models.Cart;
import com.pharma.PharmaApp.models.Medication;

public class ItemDTO {

	private Integer id;
    private @NotNull Medication medication;
    private @NotNull int quantity;

    public ItemDTO(Cart cart) {
    	this.setID(cart.getID());
    }
	
    public Integer getID() {
    	return this.id;
    }
    
    public void setID(Integer id) {
    	this.id = id;
    	return;
    }
    
    public Medication getMedication() {
    	return this.medication;
    }
    
    public void setMedication(Medication med) {
    	this.medication = med;
    	return;
    }
    
    public int getQuantity() {
    	return this.quantity;
    }
    
    public void setQuantity(int x) {
    	this.quantity = x;
    	return;
    }
    
}
