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
@Table(name = "edithistory")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class EditHistoryEntity extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "history_id")
	private Long historyId;

	@Column(name = "appointment_id")
	private Long appointmentId;

	@Column(name = "end_time")
	private Date endTime;

	@Column(name = "start_time")
	private Date startTime;

	@Column(name = "patient_id")
	private Long patientId;

	@Column(name = "physician_id")
	private Long physicianId;

	@Column(name = "edited_by")
	private Long editedBy;

	@Column(name = "reason")
	private String reason;

	@Column(name = "description")
	private String description;

	@Column(name = "subject")
	private String subject;

	@Column(name = "edit_time")
	private Date editTime;

}
