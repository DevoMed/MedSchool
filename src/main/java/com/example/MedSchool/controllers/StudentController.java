package com.example.MedSchool.controllers;



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
import com.example.MedSchool.entities.Student;
import com.example.MedSchool.model.ErrorException;
import com.example.MedSchool.model.ResponseBase;
import com.example.MedSchool.services.StudentService;


@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
    StudentService service;

	@GetMapping("/getAll")
	public ResponseEntity<?> findAll() {
try {
	return ResponseEntity.ok(service.findAll());
} catch (ErrorException e) {
	return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getIdStatus());
}
		
	}
	

	@GetMapping("/findById/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(service.findById(id));
		} catch (ErrorException  e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getIdStatus());
		}

	}

	@PostMapping("/add")
	public ResponseEntity<?> save(@RequestBody Student student) {
		return ResponseEntity.ok(service.save(student));
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody Student student, @PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(service.update(student, student.getId()));
		} catch (ErrorException  e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getIdStatus());
		}

	}

	@DeleteMapping("/inactive/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(service.inactive(id));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getIdStatus());	
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") String id) {
		try {
			return ResponseEntity.ok(service.deleteById(id));
		} catch (ErrorException e) {
			return new ResponseEntity<ResponseBase>(new ResponseBase(e),e.getIdStatus());	
		}
		
	}

}
