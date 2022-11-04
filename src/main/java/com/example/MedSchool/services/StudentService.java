package com.example.MedSchool.services;
/**
 * 
 * @author Med Guennouni
 *
 */

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.MedSchool.entities.Student;
import com.example.MedSchool.entities.Subject;
import com.example.MedSchool.model.ErrorException;
import com.example.MedSchool.repositories.StudentRepository;
import com.example.MedSchool.repositories.SubjectRepository;


@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	@Autowired
	SubjectRepository subjectRepository;

	public List<Student> findAll() {
		try {
			return repository.AllStudents();
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

	public Subject addStudentToSubject(String subjectId, String studentId) {
		Subject subject = subjectRepository.findById(subjectId).get();
		Student student = repository.findById(studentId).get();
		if(subject.students.contains(student)) {
			throw new RuntimeException("You are already enrolled in this subject...!!!");	
		};
		subject.students.add(student);
		return subjectRepository.save(subject);
	}

	public List<Student> findByfname(String name) throws Exception {
		return this.repository.findByfname(name);

	}

	public List<Student> findBylname(String name) throws Exception {
		return this.repository.findBylname(name);

	}
	
	public List<Student> findBybirthrange(Date d1, Date d2) throws Exception {
		return this.repository.findByBirthdayDateBetween(d1,d2);

	}

}
