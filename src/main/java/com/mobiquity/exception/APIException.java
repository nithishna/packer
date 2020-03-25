package com.mobiquity.exception;

public class APIException extends Exception {

	private static final long serialVersionUID = 1L;

	public APIException(String message, Exception e) {
		super(message, e);
	}

	public APIException(String message) {
		super(message);
	}
}