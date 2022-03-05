
package com.pms.schedule.utils;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class BaseEntity.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The created by. */
	@Column(name = "CREATED_BY", updatable = false)
	private Long createdBy;

	/** The created date. */
	@Column(name = "CREATED_DATE", updatable = false)
	private Date createdDate;

	/** The active status. */
	@Column(name = "ACTIVE_STATUS")
	private Integer activeStatus = 1;

	/** The updated by. */
	@Column(name = "UPDATED_BY")
	private Long updatedBy;

	/** The updated date. */
	@Column(name = "UPDATED_DATE")
	private Date updatedDate;

	
}
