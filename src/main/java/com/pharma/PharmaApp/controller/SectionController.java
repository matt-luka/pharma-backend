package com.pharma.PharmaApp.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.pharma.PharmaApp.config.APIResponse;
import com.pharma.PharmaApp.models.Sections;
import com.pharma.PharmaApp.service.SectionService;

@RestController
@RequestMapping("/section")

public class SectionController {

	@Autowired
	private SectionService secServ;
	
	@PostMapping("/create")
	public ResponseEntity<APIResponse> createCategory(@Valid @RequestBody Sections section) {
		if (Objects.nonNull(secServ.readSection(section.getSectionName()))) {
			return new ResponseEntity<APIResponse>(new APIResponse(false, "Section already exists"), HttpStatus.CONFLICT);
		}
		secServ.createSection(section);
		return new ResponseEntity<>(new APIResponse(true, "Section successfully created"), HttpStatus.CREATED);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Sections>> getCategories() {
		List<Sections> body = secServ.listSections();
		return new ResponseEntity<>(body, HttpStatus.OK);
	}
	
	@PostMapping("/update/{sectionID}")
	public ResponseEntity<APIResponse> updateCategory(@PathVariable("sectionID") Integer sectionID, @Valid @RequestBody Sections section) {
		// Check to see if the category exists.
		if (Objects.nonNull(secServ.readSection(sectionID))) {
			// If the category exists then update it.
			secServ.updateSection(sectionID, section);
			return new ResponseEntity<APIResponse>(new APIResponse(true, "Section successfully updated"), HttpStatus.OK);
		}

		// If the category doesn't exist then return a response of unsuccessful.
		return new ResponseEntity<>(new APIResponse(false, "Section does not exist"), HttpStatus.NOT_FOUND);
	}
}
