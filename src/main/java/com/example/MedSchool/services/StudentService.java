package com.example.MedSchool.services;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.MedSchool.entities.Student;
import com.example.MedSchool.model.ErrorException;
import com.example.MedSchool.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public List<Student> findAll() {
		try {
			return repository.findAll();
		} catch (ErrorException e) {
			return null;
		}

	}

	public Student findById(String id) throws NoSuchElementException {

		return repository.findById(id).get();
	}

	public Student save(Student student) {

		student.setCreationDate(new Date());
		student.setActive(true);
		return repository.save(student);
	}

	public Student update(Student student, String id) {
		try {
			student.setModificationDate(new Date());
			String dni = student.getDni();
			student.setDni(dni);
			repository.save(student);
		} catch (NoSuchElementException e) {
			return null;
		}

		return null;
	}

	public Student inactive(String id) {
		Optional<Student> studentFind = repository.findById(id);
		Student studentInact = studentFind.get();

		if (!studentInact.getActive()) {
			throw new RuntimeException("the student is already inactive!!");
		}
		studentInact.setModificationDate(new Date());
		studentInact.setActive(false);
		return repository.save(studentInact);
	}

	public Student deleteById(String id) {

		repository.deleteById(id);
		return null;
	}

}
