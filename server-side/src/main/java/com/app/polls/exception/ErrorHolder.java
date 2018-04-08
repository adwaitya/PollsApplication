package com.app.polls.exception;

/**
 * @author Adwaitya
 */

public class ErrorHolder extends RuntimeException {
	private String internalErrorMessage;
	private String externalMessage;
	private Exception exception;

	public ErrorHolder() {
		internalErrorMessage = "";
		externalMessage = "";
		exception = null;
	}

	public ErrorHolder(Exception exception) {
		this.internalErrorMessage = exception.getMessage();
		this.externalMessage = exception.getMessage();
		this.exception = exception;
	}

	public ErrorHolder(String externalMessage) {
		this.internalErrorMessage = externalMessage;
		this.externalMessage = externalMessage;
		this.exception = null;
	}

	public ErrorHolder(String externalMessage, Exception exception) {
		this.internalErrorMessage = externalMessage;
		this.externalMessage = externalMessage;
		this.exception = exception;
	}

	public ErrorHolder(String externalMessage, String internalErrorMessage) {
		this.internalErrorMessage = internalErrorMessage;
		this.externalMessage = externalMessage;
		this.exception = null;
	}

	public ErrorHolder(String externalMessage, String internalErrorMessage, Exception exception) {
		this.internalErrorMessage = internalErrorMessage;
		this.externalMessage = externalMessage;
		this.exception = exception;
	}

	public String getInternalErrorMessage() {
		return internalErrorMessage;
	}

	public void setInternalErrorMessage(String internalErrorMessage) {
		this.internalErrorMessage = internalErrorMessage;
	}

	public String getExternalMessage() {
		return externalMessage;
	}

	public void setExternalMessage(String externalMessage) {
		this.externalMessage = externalMessage;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}

}
