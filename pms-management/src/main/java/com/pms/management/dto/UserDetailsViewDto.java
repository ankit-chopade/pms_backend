package com.pms.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDetailsViewDto {

	private Long userId;

	private String title;

	private String firstName;

	private String lastName;

	private String emailId;
	
	private Integer roleId;

	public UserDetailsViewDto(UserDto user){
		this.title=user.getTitle();
		this.firstName= user.getFirstName();
		this.lastName = user.getLastName();
		this.userId= user.getUserId();
		this.roleId=user.getRoleId();
		this.emailId=user.getEmailId();
		
		
	}
	
}
