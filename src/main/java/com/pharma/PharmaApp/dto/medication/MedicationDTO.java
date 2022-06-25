package com.pharma.PharmaApp.dto.medication;

import javax.validation.constraints.NotNull;

import com.pharma.PharmaApp.models.Medication;
import com.pharma.PharmaApp.models.Sections;

public class MedicationDTO {

	private Integer id;
    private @NotNull String name;
    private @NotNull String dosage;
    private @NotNull String treatment_info;
    private @NotNull double price;
    private @NotNull Integer sectionID;
    
    public MedicationDTO() {
    }
    
    public MedicationDTO(@NotNull String name, @NotNull String dosage, @NotNull String treatment_info, @NotNull double price, @NotNull Integer sectionID) {
        this.name = name;
        this.dosage = dosage;
        this.treatment_info = treatment_info;
        this.price = price;
        this.sectionID = sectionID;
    }

    public MedicationDTO(Medication med) {
        this.setID(med.getID());
        this.setName(med.getName());
        this.setDosage(med.getDosage());
        this.setInfo(med.getInfo());
        this.setPrice(med.getPrice());
        this.setSectionID(med.getSection().getSectionID());
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
        this.id = id;
        return;
    }
	
    public String getName() {
    	return this.name;
    }
    
    public void setName(String name) {
    	this.name = name;
    	return;
    }
    
    public String getDosage() {
    	return this.dosage;
    }
    
    public void setDosage(String dosage) {
    	this.dosage = dosage;
    	return;
    }
    
    public String getInfo() {
    	return this.treatment_info;
    }
    
    public void setInfo(String info) {
    	this.treatment_info = info;
    	return;
    }
    
    public double getPrice() {
    	return this.price;
    }
    
    public void setPrice(double price) {
    	this.price = price;
    	return;
    }
    
    public Integer getSectionID() {
    	return this.sectionID;
    }
    
    public void setSectionID(Integer id) {
    	this.sectionID = id;
    }
	
}
