package com.musala.company.exception;

public class DatabaseException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1826913148254942199L;

	public DatabaseException(String message) {
		super(message);
		System.out.println("Database exc");
	}
}
