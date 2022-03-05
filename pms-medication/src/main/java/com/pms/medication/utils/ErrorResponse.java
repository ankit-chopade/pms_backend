package com.pms.medication.utils;

public enum ErrorResponse {

	RECORDNOTFOUND(100, "Error While Creating User");

	private final Integer code;
	private final String message;

	private ErrorResponse(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return code + " : " + message;
	}
}
