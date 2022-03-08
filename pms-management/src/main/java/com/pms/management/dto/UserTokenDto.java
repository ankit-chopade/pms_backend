package com.pms.management.dto;

public class UserTokenDto {

	private String token;

	private UserDetailsViewDto userDetails;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserDetailsViewDto getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetailsViewDto userDetails) {
		this.userDetails = userDetails;
	}

	public UserTokenDto() {

	}

	public UserTokenDto(UserDetailsViewDto userDetails,String token) {
		this.token = token;
		this.userDetails =  userDetails;
		
	}

}
