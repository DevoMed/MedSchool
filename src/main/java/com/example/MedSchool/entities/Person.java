package com.example.MedSchool.entities;
/**
 * 
 * @author Med Guennouni
 *
 */

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@MappedSuperclass
public class Person extends Base {
	
	private static final long serialVersionUID = 1L;

	@Column(name="first_name", nullable = false)
	private String firstName;
	
	@Column(name="last_name", nullable = false)
	private String lastName;
	
	@Column(unique = true, nullable = false)
	private String dni;
	
	@Temporal(TemporalType.DATE)
	@Column(name="birthday_date", nullable = false)
	private Date birthdayDate;

	public Person() {
		
	}

	public Person(String id, Date creationDate, Date modificationDate, Boolean active) {
		super(id, creationDate, modificationDate, active);
		
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
