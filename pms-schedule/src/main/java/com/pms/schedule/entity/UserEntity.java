package com.pms.schedule.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * The Class UserEntity.
 */
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

	/**
	 * 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long userId;

	/** The title. */
	@Column(name = "title")
	private String title;

	/** The first name. */
	@Column(name = "first_name")
	private String firstName;

	/** The last name. */
	@Column(name = "last_name")
	private String lastName;

	/** The email. */
	@Column(name = "email_id")
	private String emailId;

	/** The dob. */
	@Column(name = "dob")
	private Date dob;

	/** The role id. */
	@Column(name = "role_id")
	private Integer roleId;

	/** The employee id. */
	@Column(name = "employee_id")
	private String employeeId;

	/** The contact no. */
	@Column(name = "contact_no")
	private Long contactNo;

	/** The password. */
	@Column(name = "password")
	private String password;
    
    @Column(name="otp_requested_time")
	private Date otpRequestedTime;
	

}