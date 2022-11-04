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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {

	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy = "teachers")
	@JsonIgnoreProperties({"teachers","students","cordinator"})
	private List<Subject> subjects;

	@Column(name = "department_head")
	private boolean departHead;

	@OneToMany(mappedBy = "cordinator")
	@JsonIgnoreProperties({ "students", "teachers", "cordinator" })
	private List<Subject> subjectCordinator;

	public Teacher() {

	}

	public Teacher(String id, Date creationDate, Date modificationDate, Boolean active) {
		super(id, creationDate, modificationDate, active);

	}

	public Teacher(String firstName, String lastName, String dni, Date birthdayDate) {
		super(firstName, lastName, dni, birthdayDate);

	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubject(List<Subject> subjects) {
		this.subjects = subjects;
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
