package com.example.MedSchool.controllers;
/**
 * 
 * @author Med Guennouni
 *
 */

import java.util.Date;
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
import com.example.MedSchool.entities.Teacher;
import com.example.MedSchool.model.ErrorException;
import com.example.MedSchool.model.ResponseBase;
import com.example.MedSchool.services.TeacherService;


@RestController
@RequestMapping("teachers")
public class TeacherController {

	@Autowired
	TeacherService service;

	@GetMapping("/get")
	public ResponseEntity<?> findAll(){
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
	public ResponseEntity<?> save(@RequestBody Teacher teacher) {
		return ResponseEntity.ok(service.save(teacher));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Teacher teacher, @PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(service.update(teacher, teacher.getId()));
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
	
	@PutMapping("/{subjectId}/teacher/{teacherId}")
	public ResponseEntity<?> assignTeacherToSubject(@PathVariable String subjectId, @PathVariable String teacherId) {
		try {
			return ResponseEntity.ok(service.assignTeacherToSubject(subjectId, teacherId));

		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e), e.getIdStatus());
		}
	}
	
	@PutMapping("/{subjectId}/cordinator/{teacherId}")
	public ResponseEntity<?> assignCordinatorToSubject(@PathVariable String subjectId, @PathVariable String teacherId) {
		try {
			return ResponseEntity.ok(service.assignCordinatorToSubject(subjectId, teacherId));

		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e), e.getIdStatus());
		}
	}
	
	@GetMapping("search/name")
	public ResponseEntity<?> findByfname( String name ) throws Exception {
		try {
			return ResponseEntity.ok(service.findByfname(name));

		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e), e.getIdStatus());
		}
	}
	
	@GetMapping("search/lname")
	public ResponseEntity<?> findBylname(String lname ) throws Exception {
		try {
			return ResponseEntity.ok(service.findBylname(lname));

		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e), e.getIdStatus());
		}
	}
	
	@GetMapping("search/range")
	public ResponseEntity<?> findBybirthrange(Date d1,Date d2 ) throws Exception {
		try {
			return ResponseEntity.ok(service.findBybirthrange(d1,d2));

		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e), e.getIdStatus());
		}
	}
}
