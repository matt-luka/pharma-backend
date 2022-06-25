package com.pharma.PharmaApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pharma.PharmaApp.models.Sections;

@Repository
public interface SectionRepository extends JpaRepository<Sections, Integer> {

	Sections findBySectionName(String sectionName);
	
}
