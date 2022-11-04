package com.example.MedSchool.model;
/**
 * 
 * @author Med Guennouni
 *
 */

public class ResponseBase {
	
	private Long id;
	private String message;
	
	
	public ResponseBase(Long id, String message) {
		super();
		this.id = id;
		this.message = message;
	}
	
	public ResponseBase(ErrorException e) {
		super();
		this.id = e.getId();
		this.message = e.getMessage();
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
	

}
