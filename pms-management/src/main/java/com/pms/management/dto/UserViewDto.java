package com.pms.management.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserViewDto {
	
	
	private Long userId;

	private String title;

	
	private String firstName;

	private String lastName;

	private String emailId;

	
	private Date dob;

	
	private Integer roleId;

	
	private String employeeId;

	
	private Long contactNo;


	private String password;

	
	private Integer activeStatus;
	
	private Date createdDate;

}
