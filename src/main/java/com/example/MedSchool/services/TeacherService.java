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
import com.example.MedSchool.entities.Subject;
import com.example.MedSchool.entities.Teacher;
import com.example.MedSchool.model.ErrorException;
import com.example.MedSchool.repositories.SubjectRepository;
import com.example.MedSchool.repositories.TeacherRepository;

@Service
public class TeacherService {

	@Autowired
	TeacherRepository repository;
	@Autowired
	SubjectRepository subjectRepository;

	public List<Teacher> findAll() {
		try {
			
			return repository.AllTeachers();
		} catch (ErrorException e) {
			return null;
		}

	}

	public Teacher findById(String id) throws NoSuchElementException {

		return repository.findById(id).get();
	}

	public Teacher save(Teacher teacher) {

		teacher.setCreationDate(new Date());
		teacher.setActive(true);
		return repository.save(teacher);
	}

	public Teacher update(Teacher teacher, String id) {
		try {
			teacher.setModificationDate(new Date());
			repository.save(teacher);
		} catch (NoSuchElementException e) {
			return null;
		}

		return null;
	}

	public Teacher inactive(String id) {
		Optional<Teacher> teacherFind = repository.findById(id);
		Teacher teacherInact = teacherFind.get();

		if (!teacherInact.getActive()) {
			throw new RuntimeException("the teacher is already inactive!!");
		}
		teacherInact.setModificationDate(new Date());
		teacherInact.setActive(false);
		return repository.save(teacherInact);
	}

	public Teacher deleteById(String id) {

		repository.deleteById(id);
		return null;
	}
	public Subject assignTeacherToSubject(String subjectId, String teacherId) {
		Subject subject = subjectRepository.findById(subjectId).get();
		Teacher teacher = repository.findById(teacherId).get();
		if(subject.teachers.contains(teacher)) {
			throw new RuntimeException("you are already teaching in this subject!!");	
		};
		subject.teachers.add(teacher);
		return subjectRepository.save(subject);
	}
	
	public Subject assignCordinatorToSubject(String subjectId, String teacherId) {
		Subject subject = subjectRepository.findById(subjectId).get();
		Teacher teacher = repository.findById(teacherId).get();
		Teacher cordinator=subject.getCordinator();
		
		if(!(cordinator==null)) {
			throw new RuntimeException("This subject has already coordinator!!");		
		};
		subject.setCordinator(teacher);
		return subjectRepository.save(subject);
	}
	
	public List<Teacher> findByfname(String name) throws Exception {
		return this.repository.findByfname(name);

	}

	public List<Teacher> findBylname(String name) throws Exception {
		return this.repository.findBylname(name);

	}
	
	public List<Teacher> findBybirthrange(Date d1, Date d2) throws Exception {
		return this.repository.findByBirthdayDateBetween(d1,d2);

	}

}
