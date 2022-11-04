package com.example.MedSchool.model;
/**
 * 
 * @author Med Guennouni
 *
 */

import org.springframework.http.HttpStatus;

public class ErrorException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String message;
	
	private HttpStatus idStatus;
	
	

	public ErrorException() {
		super();
	}
	public ErrorException(Errors error, HttpStatus idStatus) {
		super();
		this.id = error.getId();
		this.message = error.getMessage();
		this.idStatus = idStatus;
		}



	public ErrorException(Long id, String message, HttpStatus idStatus) {
		super();
		this.id = id;
		this.message = message;
		this.idStatus = idStatus;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(HttpStatus idStatus) {
		this.idStatus = idStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
