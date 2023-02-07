package com.app.custom_exception;

public class ResponseException extends RuntimeException {
	public ResponseException(String mesg) {
		super(mesg);
	}

}
