package com.pharma.PharmaApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharma.PharmaApp.models.Sections;
import com.pharma.PharmaApp.repository.SectionRepository;

@Service
public class SectionService {

	@Autowired
	private SectionRepository sectRepo;
	
	public Sections readSection(String sectionName) {
		return sectRepo.findBySectionName(sectionName);
	}
	
	public Optional<Sections> readSection(Integer sectionID) {
		return sectRepo.findById(sectionID);
	}
	
	public void createSection(Sections section) {
		sectRepo.save(section);
	}
	
	public List<Sections> listSections() {
		return sectRepo.findAll();
	}
	
	public void updateSection(Integer sectionID, Sections newSection) {
		Sections section = sectRepo.findById(sectionID).get();
		section.setSectionName(newSection.getSectionName());
		section.setSectionDesc(newSection.getSectionDesc());
		section.setSectionURL(newSection.getSectionURL());
		sectRepo.save(section);
	}
	
	
}
