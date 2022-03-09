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
public class PatientAppointmentDto {

	private Long appointmentId;

	private Date endTime;

	private String endTimezone;

	private Long id;

	private Boolean isAllDay;

	private String recurrenceRule;

	private Date startTime;

	private String startTimezone;

	private String subject;

	private Boolean isReadonly;

	private Boolean isBlock;

	private String description;

	private Long patientId;

	private Long physicianId;

}
