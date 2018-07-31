package com.musala.company.exception;

import java.io.Serializable;

public class DataNotFoundException extends RuntimeException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1910813424479350257L;

	public DataNotFoundException(String message) {
		super(message);
		System.out.println("Data not found");
	}

}
