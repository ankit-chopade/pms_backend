package com.pms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="allergy_map")
public class AllergyMapEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="allergyMap_Id")
	private Integer allergyMapId;
	
	@Column(name="allergy_id")
	private Integer allergyId;

	public Integer getAllergyMapId() {
		return allergyMapId;
	}

	public void setAllergyMapId(Integer allergyMapId) {
		this.allergyMapId = allergyMapId;
	}

	public Integer getAllergyId() {
		return allergyId;
	}

	public void setAllergyId(Integer allergyId) {
		this.allergyId = allergyId;
	}

	public AllergyMapEntity(Integer allergyMapId, Integer allergyId) {
		super();
		this.allergyMapId = allergyMapId;
		this.allergyId = allergyId;
	}

	public AllergyMapEntity() {
		super();
	}

	
	
}
