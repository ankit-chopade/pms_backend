package com.pms.management.dto;

import java.util.Date;


public class UserDto {
	
	
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

	private int active;
	

	public int getActive() {
		return active;
	}


	public void setActive(int active) {
		this.active = active;
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


	
	

}
