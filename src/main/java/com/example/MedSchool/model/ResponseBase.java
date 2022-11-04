package com.example.MedSchool.model;

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

}
