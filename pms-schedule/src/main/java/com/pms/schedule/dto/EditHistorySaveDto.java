package com.pms.schedule.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class EditHistorySaveDto {
	
	private Long historyId;

	private Long appointmentId;

	private Date endTime;

	private Date startTime;

	private Long patientId;

	private Long physicianId;

	private Long editedBy;

	private String reason;

	private String description;

	private String subject;

	private Date editTime;

}
