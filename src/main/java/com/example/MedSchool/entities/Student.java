package com.example.MedSchool.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="students")
public class Student extends Person implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
    @JsonIgnore
	@ManyToMany(mappedBy = "students")
	private List<Subject> subject;
	
	@Column(name="average_grade")
	private float avgGrade;
	

	public Student() {
		
	}

	public Student(String id, Date creationDate, Date modificationDate, Boolean active) {
		super(id, creationDate, modificationDate, active);
		
	}

	public Student(String firstName, String lastName, String dni, Date birthdayDate) {
		super(firstName, lastName, dni, birthdayDate);
		
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

	public float getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(float avgGrade) {
		this.avgGrade = avgGrade;
	}
	

}
