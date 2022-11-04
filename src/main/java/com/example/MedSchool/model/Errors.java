package com.example.MedSchool.model;
/**
 * 
 * @author Med Guennouni
 *
 */

public enum Errors {
	
	ID(1L,"not found"),
	UNKNOWN(2L,"unknown"),
	EMPTY(3l,"empty list");
	
	private Long id;
	private String message;
	private Errors(Long id, String mesage) {
		this.id = id;
		this.message = mesage;
	}
	public Long getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}

}
