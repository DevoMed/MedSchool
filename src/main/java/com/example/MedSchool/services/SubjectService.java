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
import com.example.MedSchool.model.ErrorException;
import com.example.MedSchool.repositories.SubjectRepository;



@Service
public class SubjectService {

	@Autowired
	SubjectRepository repository;
	

	public List<Subject> findAll() {
		try {
			
			return repository.AllSubjets();
		} catch (ErrorException e) {
			return null;
		}

	}

	public Subject findById(String id) throws NoSuchElementException {
		return repository.findById(id).get();
	}

	public Subject save(Subject subject) {
		subject.setCreationDate(new Date());
		subject.setActive(true);
		return repository.save(subject);
	}

	public Subject update(Subject subject, String id) {
		try {
			subject.setModificationDate(new Date());
			repository.save(subject);
		} catch (NoSuchElementException e) {
			return null;
		}

		return null;
	}

	public Subject inactive(String id) {
		Optional<Subject> subjectFind = repository.findById(id);
		Subject subjectInact = subjectFind.get();

		if (!subjectInact.getActive()) {
			throw new RuntimeException("the Subject is already inactive!!");
		}
		subjectInact.setModificationDate(new Date());
		subjectInact.setActive(false);
		return repository.save(subjectInact);
	}

	public Subject deleteById(String id) {
		repository.deleteById(id);
		return null;
	}


}
