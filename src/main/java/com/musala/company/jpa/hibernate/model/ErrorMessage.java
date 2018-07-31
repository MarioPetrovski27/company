package com.musala.company.jpa.hibernate.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage {
	private String errorMessageValue;
	private String errorMessageStatusCode;
	private String timestamp;
	
	public ErrorMessage() {
	}

	public ErrorMessage(String errorMessageValue, String errorMessageStatusCode, String timestamp) {
		this.errorMessageValue = errorMessageValue;
		this.errorMessageStatusCode = errorMessageStatusCode;
		this.timestamp = timestamp;
	}

	/**
	 * @return the errorMessageValue
	 */
	public String getErrorMessageValue() {
		return errorMessageValue;
	}

	/**
	 * @param errorMessageValue
	 *            the errorMessageValue to set
	 */
	public void setErrorMessageValue(String errorMessageValue) {
		this.errorMessageValue = errorMessageValue;
	}

	/**
	 * @return the errorMessageKey
	 */
	public String getErrorMessageStatusCode() {
		return errorMessageStatusCode;
	}

	/**
	 * @param errorMessageKey
	 *            the errorMessageKey to set
	 */
	public void setErrorMessageStatusCode(String errorMessageStatusCode) {
		this.errorMessageStatusCode = errorMessageStatusCode;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	


}