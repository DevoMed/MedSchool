package com.example.MedSchool.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Person extends Base {
	
	@Column(name="fisrt_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String dni;
	
	@Column(name="birthday_date")
	private Date birthdayDate;

	public Person() {
		// TODO Auto-generated constructor stub
	}

	public Person(String id, Date creationDate, Date modificationDate, Boolean active) {
		super(id, creationDate, modificationDate, active);
		// TODO Auto-generated constructor stub
	}

	public Person(String firstName, String lastName, String dni, Date birthdayDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dni = dni;
		this.birthdayDate = birthdayDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Date getBirthdayDate() {
		return birthdayDate;
	}

	public void setBirthdayDate(Date birthdayDate) {
		this.birthdayDate = birthdayDate;
	}
	

}
