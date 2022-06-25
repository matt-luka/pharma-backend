package com.pharma.PharmaApp.dto.user;

public class RegisterDTO {
	
    private String firstName;

    private String lastName;

    private String email;
    
    private String phone;
    
    private String zipcode;

    private String password;
	
    public String getFirstName() {
    	return this.firstName;
    }
    
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    	return;
    }
    
    public String getLastName() {
    	return this.lastName;
    }
    
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    	return;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    	return;
    }
    
    public String getPhone() {
    	return this.phone;
    }
    
    public void setPhone(String phone) {
    	this.phone = phone;
    	return;
    }
    
    public String getZip() {
    	return this.zipcode;
    }
    
    public void setZip(String zipcode) {
    	this.zipcode = zipcode;
    	return;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    	return;
    }

}
