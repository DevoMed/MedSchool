package com.example.MedSchool.entities;
/**
 * 
 * @author Med Guennouni
 *
 */

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "students")
public class Student extends Person {

	private static final long serialVersionUID = 1L;

	@JsonIgnoreProperties({ "students", "teachers", "cordinator"})
	@ManyToMany(mappedBy = "students")
	private List<Subject> subjects;

	@Column(name = "average_grade")
	private float avgGrade;

	public Student() {

	}

	public Student(String id, Date creationDate, Date modificationDate, Boolean active) {
		super(id, creationDate, modificationDate, active);

	}

	public Student(String firstName, String lastName, String dni, Date birthdayDate) {
		super(firstName, lastName, dni, birthdayDate);

	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public float getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(float avgGrade) {
		this.avgGrade = avgGrade;
	}

}
