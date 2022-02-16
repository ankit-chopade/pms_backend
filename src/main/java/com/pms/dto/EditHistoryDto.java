package com.pms.dto;

import java.util.Date;

import com.pms.entity.EditHistoryEntity;

public class EditHistoryDto {
	
    private Date endTime;
	
    private Date startTime;
		
    private String physicianName;
	
    private String editedBy;
	
    private String reason;
	
    private String description;	
	
    private String subject;
	
    private Date editTime;

	public Date getEndTime() {
		return endTime;
	}

	public EditHistoryDto(EditHistoryEntity editHistoryEntity) {
		this.endTime = editHistoryEntity.getEndTime();
		this.startTime=editHistoryEntity.getStartTime();
		this.reason = editHistoryEntity.getReason();
		this.description = editHistoryEntity.getDescription();
		this.subject = editHistoryEntity.getSubject();
		this.editTime = editHistoryEntity.getEditTime();
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getPhysicianName() {
		return physicianName;
	}

	public void setPhysicianName(String physicianName) {
		this.physicianName = physicianName;
	}

	public String getEditedBy() {
		return editedBy;
	}

	public void setEditedBy(String editedBy) {
		this.editedBy = editedBy;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}
	
    
}
