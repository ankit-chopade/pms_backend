package com.pms.model;

import java.time.LocalDateTime;

public class UserNotes {

	
	private int noteId;
	private String message;
	private LocalDateTime date;
	private Long senderId;
	private Long recieverId;
	private boolean urgency;
	private String reply; 
	private String firstName;
	private String lastName;
	private String role;
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public Long getSenderId() {
		return senderId;
	}
	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}
	public Long getRecieverId() {
		return recieverId;
	}
	public void setRecieverId(Long recieverId) {
		this.recieverId = recieverId;
	}
	public boolean isUrgency() {
		return urgency;
	}
	public void setUrgency(boolean urgency) {
		this.urgency = urgency;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
