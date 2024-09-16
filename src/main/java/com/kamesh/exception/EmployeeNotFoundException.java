package com.kamesh.exception;

import org.springframework.stereotype.Component;

@Component
public class EmployeeNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeNotFoundException(String message) {
		super(message);
	}

	public EmployeeNotFoundException(String string, Exception e) {
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeNotFoundException() {
		// TODO Auto-generated constructor stub
	}

}
