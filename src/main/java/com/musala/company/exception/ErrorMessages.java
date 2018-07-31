package com.musala.company.exception;

public enum ErrorMessages {

	INVALID_DATA_INPUT("Invalid data format provided."),
	MISSING_REQUIRED_FIELD("Missing required field. Please check documentation for required fields"),
	COULD_NOT_CREATE_RECORD("Could not create record"),
	COULD_NOT_UPDATE_RECORD("Could not update record"),
	COULD_NOT_DELETE_RECORD("Could not delete record"),
	NO_RECORD_FOUND("No record found for provided id"),
	RECORD_ALREADY_EXISTS("Record already exists"),
	INTERNAL_SERVER_ERROR("Something went wrong. Please repeat this operation later.");

	private String errorMessage;

	ErrorMessages(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage
	 *            the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
