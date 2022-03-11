package com.pms.management.dto;

import java.util.Date;


public class UserViewDto {
	
	
	private Long userId;

	private String title;

	
	private String firstName;

	private String lastName;

	private String emailId;

	
	private Date dob;

	
	private Integer roleId;

	
	private Integer employeeId;

	
	private Long contactNo;


	private String password;

	
	private Integer activeStatus;
	

	public Integer getActiveStatus() {
		return activeStatus;
	}


	public void setActiveStatus(Integer activeStatus) {
		this.activeStatus = activeStatus;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public Integer getRoleId() {
		return roleId;
	}


	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


	public Integer getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}


	public Long getContactNo() {
		return contactNo;
	}


	public void setContactNo(Long contactNo) {
		this.contactNo = contactNo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public UserViewDto(Long userId, String title, String firstName, String lastName, String emailId, Date dob,
			Integer roleId, Integer employeeId, Long contactNo, String password, Integer activeStatus) {
		super();
		this.userId = userId;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.dob = dob;
		this.roleId = roleId;
		this.employeeId = employeeId;
		this.contactNo = contactNo;
		this.password = password;
		this.activeStatus = activeStatus;
	}


	public UserViewDto() {
		super();
	}


	
	

}
