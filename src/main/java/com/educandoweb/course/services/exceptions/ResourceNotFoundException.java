package com.educandoweb.course.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	//RuntimeException is an exception that you're not forced to treat by the compiler 
	
	public ResourceNotFoundException(Object id) {
		super("Resource not found. id" + id);
	}
}
