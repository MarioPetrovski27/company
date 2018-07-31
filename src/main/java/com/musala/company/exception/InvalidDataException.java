package com.musala.company.exception;

public class InvalidDataException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 520063935665362941L;
	
	public InvalidDataException(String message) {
		super(message);
		System.out.println("Invalid Data");
	}
}
