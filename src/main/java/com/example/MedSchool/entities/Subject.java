package com.example.MedSchool.entities;
/**
 * 
 * @author Med Guennouni
 *
 */

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.example.MedSchool.model.Department;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "subjects")
public class Subject extends Base {

	private static final long serialVersionUID = 1L;

	@Column(name = "subject_name")
	private String subjectName;

	@Enumerated(EnumType.STRING)
	private Department department;
	

	@ManyToMany
	@JoinTable(name = "subject_teacher", joinColumns = @JoinColumn(name = "id_subject", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_teacher", referencedColumnName = "id"))
	@JsonIgnoreProperties({"subjects","students","subjectCordinator"})
	public List<Teacher> teachers;

	@ManyToMany
	@JoinTable(name = "subject_student", joinColumns = @JoinColumn(name = "id_subject", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "id_student", referencedColumnName = "id"))
	@JsonIgnoreProperties("subjects")
	public List<Student> students;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cordinator", referencedColumnName = "id")
	@JsonIgnoreProperties({ "subjects", "subjectCordinator" })
	private Teacher cordinator;

	public Subject() {

	}

	public Subject(String id, Date creationDate, Date modificationDate, Boolean active) {
		super(id, creationDate, modificationDate, active);

	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Teacher getCordinator() {
		return cordinator;
	}

	public void setCordinator(Teacher cordinator) {
		this.cordinator = cordinator;
	}

}
