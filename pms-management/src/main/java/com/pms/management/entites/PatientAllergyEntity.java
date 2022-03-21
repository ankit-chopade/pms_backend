package com.pms.management.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.pms.management.utils.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="patient_allergy")
public class PatientAllergyEntity extends BaseEntity  implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patientAllergy_Id")
	private Long patientAllergyId;
	
	@Column(name="allergy_id")
	private Integer allergyId;
	
	@Column(name="allergy_isFatal")
	private Integer allergyIsFatal;
	
}
