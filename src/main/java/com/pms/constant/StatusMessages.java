package com.pms.constant;

public enum StatusMessages {

	NOTE_SEND_SUCCESSFULLY("Note is send successfully"),
	SERVER_ERROR("Error while processing request"),
	REPLY_SEND_SUCCESSFULLY("Reply is successfully send"),
	NOTE_NOT_FOUND("Note not found !"),
	NOTE_DELETED_SUCCESSFULLY("Note deleted successfully");

	private String message;

	private StatusMessages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
}
}