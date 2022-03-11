package com.pms.schedule.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pms.schedule.utils.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patient_appointment")
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
public class PatientAppointmentEntity extends BaseEntity  implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "appointment_id")
	private Long appointmentId;
	
	@Column(name = "end_time")
    private Date endTime;
	
	@Column(name = "end_time_zone")
	private String endTimezone;
	
	@Column(name = "appointment_number")
	private Long id;
	
	@Column(name = "is_all_day")
	private Boolean isAllDay;
	
	@Column(name = "recurrence_rule")
	private  String recurrenceRule;
	
	@Column(name = "start_time")
	private Date startTime;
	
	@Column(name = "start_time_zone")
	private String startTimezone;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "is_readonly")
	private Boolean isReadonly;
	
	@Column(name = "is_block")
	private Boolean isBlock;
	
	@Column(name ="description")
	private String description;
	

	@Column(name = "patient_id")
	private Long patientId;
	
	@Column(name = "physician_id")
	private Long physicianId;
	

}
