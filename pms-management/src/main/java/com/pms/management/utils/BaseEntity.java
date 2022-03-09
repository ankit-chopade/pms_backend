
package com.pms.management.utils;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * The Class BaseEntity.
 */
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

	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */
	public long getCreatedBy() {
		return createdBy;
	}

	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the created date.
	 *
	 * @return the created date
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * Sets the created date.
	 *
	 * @param createdDate the new created date
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * Gets the active status.
	 *
	 * @return the active status
	 */
	public Integer getActiveStatus() {
		return activeStatus;
	}

	/**
	 * Sets the active status.
	 *
	 * @param activeStatus the new active status
	 */
	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}

	/**
	 * Gets the updated by.
	 *
	 * @return the updated by
	 */
	public Long getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * Sets the updated by.
	 *
	 * @param updatedBy the new updated by
	 */
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * Gets the updated date.
	 *
	 * @return the updated date
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * Sets the updated date.
	 *
	 * @param updatedDate the new updated date
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * Before create.
	 */

	/**
	 * Instantiates a new base entity.
	 */
	public BaseEntity() {
		super();
	}
}
