package com.example.MedSchool.controllers;
/**
 * 
 * @author Med Guennouni
 *
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.MedSchool.entities.Subject;
import com.example.MedSchool.model.ErrorException;
import com.example.MedSchool.model.ResponseBase;
import com.example.MedSchool.services.SubjectService;

@RestController
@RequestMapping("subjects")
public class SubjectController {

	@Autowired
	SubjectService service;

	@GetMapping("/get")
	public ResponseEntity<?> findAll( ) {
		try {
			return ResponseEntity.ok(service.findAll());
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e), e.getIdStatus());
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(service.findById(id));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e), e.getIdStatus());
		}

	}

	@PostMapping("/add")
	public ResponseEntity<?> save(@RequestBody Subject subject) {
		return ResponseEntity.ok(service.save(subject));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Subject subject, @PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(service.update(subject, subject.getId()));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e), e.getIdStatus());
		}

	}

	@DeleteMapping("/inactive/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(service.inactive(id));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e), e.getIdStatus());
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(service.deleteById(id));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e), e.getIdStatus());
		}

	}


	
}
