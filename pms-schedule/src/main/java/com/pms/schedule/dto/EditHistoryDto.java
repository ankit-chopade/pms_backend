package com.pms.schedule.dto;

import java.util.Date;

import com.pms.schedule.entity.EditHistoryEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
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
	
    
}
