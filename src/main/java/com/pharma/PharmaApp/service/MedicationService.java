package com.pharma.PharmaApp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.PharmaApp.dto.medication.MedicationDTO;
import com.pharma.PharmaApp.models.Medication;
import com.pharma.PharmaApp.models.Sections;
import com.pharma.PharmaApp.repository.MedicationRepository;

@Service
public class MedicationService {

    @Autowired
    private MedicationRepository medRepository;
    
    public void addMedication(MedicationDTO medDTO, Sections section) {
        Medication med = getMedicationFromDTO(medDTO, section);
        medRepository.save(med);
    }

    public static Medication getMedicationFromDTO(MedicationDTO medDTO, Sections section) {
        Medication med = new Medication();
        med.setName(medDTO.getName());
        med.setDosage(medDTO.getDosage());
        med.setInfo(medDTO.getInfo());
        med.setPrice(medDTO.getPrice());
        med.setSection(section);
        return med;
    }
    
    public List<MedicationDTO> listMedication() {
        // first fetch all the products
        List<Medication> meds = medRepository.findAll();
        List<MedicationDTO> medDTOs = new ArrayList<>();

        for(Medication med : meds) {
            // for each product change it to DTO
            medDTOs.add(new MedicationDTO(med));
        }
        return medDTOs;
    }
    
    public void updateMedication(Integer medicationID, MedicationDTO medDTO, Sections section) {
        Medication med = getMedicationFromDTO(medDTO, section);
        // set the id for updating
        med.setID(medicationID);
        // update
        medRepository.save(med);
    }
	
}
