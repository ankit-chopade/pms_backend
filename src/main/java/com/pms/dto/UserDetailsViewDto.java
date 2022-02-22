package com.pms.dto;

public class UserDetailsViewDto {

	private Long userId;

	private String title;

	private String firstName;

	private String lastName;

	private String emailId;
	
	private Integer roleId;

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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public UserDetailsViewDto(UserDto user){
		this.title=user.getTitle();
		this.firstName= user.getFirstName();
		this.lastName = user.getLastName();
		this.userId= user.getUserId();
		this.roleId=user.getRoleId();
		this.emailId=user.getEmailId();
		
		
	}
	
}
