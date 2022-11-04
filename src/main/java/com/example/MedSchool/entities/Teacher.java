package com.example.MedSchool.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "teachers")
public class Teacher extends Person implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "teachers")
	private List<Subject> subject;
	
	@Column(name="department_head")
	private boolean departHead;
	@JsonIgnore
	@OneToMany(mappedBy = "teachers")
	//@Column(name="subjects")
	private List<Subject> subjectCordinator;

	public Teacher() {

	}

	public Teacher(String id, Date creationDate, Date modificationDate, Boolean active) {
		super(id, creationDate, modificationDate, active);

	}

	public Teacher(String firstName, String lastName, String dni, Date birthdayDate) {
		super(firstName, lastName, dni, birthdayDate);

	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

	public boolean isDepartHead() {
		return departHead;
	}

	public void setDepartHead(boolean departHead) {
		this.departHead = departHead;
	}

	public List<Subject> getSubjectCordinator() {
		return subjectCordinator;
	}

	public void setSubjectCordinator(List<Subject> subjectCordinator) {
		this.subjectCordinator = subjectCordinator;
	}

}
