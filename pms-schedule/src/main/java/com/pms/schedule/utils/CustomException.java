
package com.pms.schedule.utils;

import org.springframework.http.HttpStatus;

public class CustomException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String errorMsg;

	private final int errorCode;

	public CustomException(ErrorResponse errorResponse) {
		super(errorResponse.getMessage());
		this.errorMsg = errorResponse.getMessage();
		this.errorCode = errorResponse.getCode();
	}

	public CustomException(int code, String message) {
		super(message);
		this.errorCode = code;
		this.errorMsg = message;

	}

	public CustomException(HttpStatus status, String message) {
		super(message);
		this.errorCode = status.value();
		this.errorMsg = message;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		return String.format("CustomException [errorMsg=%s, errorCode=%s]", errorMsg, errorCode);
	}

}