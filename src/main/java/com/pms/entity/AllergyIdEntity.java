package com.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="allergyId")
public class AllergyIdEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="allerg_id")
	private Integer allergyId;
	
	@Column(name="allergDetails_id")
	private String allergyDetailsId;

	public Integer getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(Integer allergyId) {
		this.allergyId = allergyId;
	}

	public String getAllergyDetailsId() {
		return allergyDetailsId;
	}

	public void setAllergyDetailsId(String allergyDetailsId) {
		this.allergyDetailsId = allergyDetailsId;
	}

	@Override
	public String toString() {
		return "AllergyIdEntity [allergyId=" + allergyId + ", allergyDetailsId=" + allergyDetailsId + "]";
	}
	
	
}
