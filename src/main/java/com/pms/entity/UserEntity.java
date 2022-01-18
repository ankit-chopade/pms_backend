package com.pms.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The Class UserEntity.
 */
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity
@Table(name="users")
public class UserEntity {

	/**
	 * 
	 */

	/** The user id. */
	@Id
	
	@Column(name="user_id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId=51l;
	
	/** The title. */
	@Column(name="title")
	private String title;

	/** The first name. */
	@Column(name="first_name")
	private String firstName;
	
	/** The last name. */
	@Column(name="last_name")
	private String lastName;
	
	/** The email. */
	@Column(name="email_id")
	private String emailId;
	
	/** The dob. */
	@Column(name="dob")
	private Date dob;
	
	/** The role id. */
	@Column(name="role_id")
	private Integer roleId;
	
	/** The employee id. */
	@Column(name="employee_id")
	private Integer employeeId;
	
	/** The contact no. */
	@Column(name="contact_no")
	private Long contactNumber;

	/** The password. */
	@Column(name="password")
	private String password;
	
	/** The active. */
	@Column(name="active")
	private Integer active;
	
	
	 @ElementCollection(fetch = FetchType.EAGER)
	   @CollectionTable(
			    name="roles",
			    joinColumns = @JoinColumn(name="user_id")
			   )
	   @Column(name="role")
	   private Set<String> roles;


	public UserEntity(Long userId, String title, String firstName, String lastName, String emailId, Date dob,
			Integer roleId, Integer employeeId, Long contactNumber, String password, Integer active,
			Set<String> roles) {
		super();
		this.userId = userId;
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.dob = dob;
		this.roleId = roleId;
		this.employeeId = employeeId;
		this.contactNumber = contactNumber;
		this.password = password;
		this.active = active;
		this.roles = roles;
	}


	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
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


	public Long getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getActive() {
		return active;
	}


	public void setActive(Integer active) {
		this.active = active;
	}


	public Set<String> getRoles() {
		return roles;
	}


	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

//	/**
//	 * Instantiates a new user entity.
//	 */
//	public UserEntity() {
//	}
//
//	/**
//	 * Instantiates a new user entity.
//	 *
//	 * @param userId the user id
//	 * @param title the title
//	 * @param firstName the first name
//	 * @param lastName the last name
//	 * @param email the email
//	 * @param dob the dob
//	 * @param roleId the role id
//	 * @param employeeId the employee id
//	 * @param contactNo the contact no
//	 * @param password the password
//	 * @param active the active
//	 */
//	public UserEntity(Long userId, String title, String firstName, String lastName, String emailId, Date dob,
//			Integer employeeId, Long contactNo, String userPassword, Integer active, Set<String> roles) {
//		super();
//		this.userId = userId;
//		this.title = title;
//		this.firstName = firstName;
//		this.lastName = lastName;
//		this.emailId = emailId;
//		this.dob = dob;
//		this.employeeId = employeeId;
//		this.contactNo = contactNo;
//		this.userPassword = userPassword;
//		this.active = active;
//		this.roles = roles;
//	}
// 
//
//	/**
//	 * Gets the user id.
//	 *
//	 * @return the user id
//	 */
//	public Long getUserId() {
//		return userId;
//	}
//
//	
//	/**
//	 * Sets the user id.
//	 *
//	 * @param userId the new user id
//	 */
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
//
//	/**
//	 * Gets the title.
//	 *
//	 * @return the title
//	 */
//	public String getTitle() {
//		return title;
//	}
//
//	/**
//	 * Sets the title.
//	 *
//	 * @param title the new title
//	 */
//	public void setTitle(String title) {
//		this.title = title;
//	}
//
//	/**
//	 * Gets the first name.
//	 *
//	 * @return the first name
//	 */
//	public String getFirstName() {
//		return firstName;
//	}
//
//	/**
//	 * Sets the first name.
//	 *
//	 * @param firstName the new first name
//	 */
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	/**
//	 * Gets the last name.
//	 *
//	 * @return the last name
//	 */
//	public String getLastName() {
//		return lastName;
//	}
//
//	/**
//	 * Sets the last name.
//	 *
//	 * @param lastName the new last name
//	 */
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	/**
//	 * Gets the email.
//	 *
//	 * @return the email
//	 */
//	public String getEmailId() {
//		return emailId;
//	}
//
//	/**
//	 * Sets the email.
//	 *
//	 * @param email the new email
//	 */
//	public void setEmailId(String emailId) {
//		this.emailId = emailId;
//	}
//
//	/**
//	 * Gets the dob.
//	 *
//	 * @return the dob
//	 */
//	public Date getDob() {
//		return dob;
//	}
//
//	/**
//	 * Sets the dob.
//	 *
//	 * @param dob the new dob
//	 */
//	public void setDob(Date dob) {
//		this.dob = dob;
//	}
//
//	/**
//	 * Gets the role id.
//	 *
//	 * @return the role id
//	 */
////	public Integer getRoleId() {
////		return roleId;
////	}
//
//	/**
//	 * Sets the role id.
//	 *
//	 * @param roleId the new role id
//	 */
////	public void setRoleId(Integer roleId) {
////		this.roleId = roleId;
////	}
//
//	/**
//	 * Gets the employee id.
//	 *
//	 * @return the employee id
//	 */
//	public Integer getEmployeeId() {
//		return employeeId;
//	}
//
//	public Set<String> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<String> roles) {
//		this.roles = roles;
//	}
//
//	/**
//	 * Sets the employee id.
//	 *
//	 * @param employeeId the new employee id
//	 */
//	public void setEmployeeId(Integer employeeId) {
//		this.employeeId = employeeId;
//	}
//
//	/**
//	 * Gets the contact no.
//	 *
//	 * @return the contact no
//	 */
//	public Long getContactNo() {
//		return contactNo;
//	}
//
//	/**
//	 * Sets the contact no.
//	 *
//	 * @param contactNo the new contact no
//	 */
//	public void setContactNo(Long contactNo) {
//		this.contactNo = contactNo;
//	}
//
//	/**
//	 * Gets the password.
//	 *
//	 * @return the password
//	 */
//	public String getUserPassword() {
//		return userPassword;
//	}
//
//	/**
//	 * Sets the password.
//	 *
//	 * @param password the new password
//	 */
//	public void setUserPassword(String userPassword) {
//		this.userPassword = userPassword;
//	}
//
//	/**
//	 * Gets the active.
//	 *
//	 * @return the active
//	 */
//	public Integer getActive() {
//		return active;
//	}
//
//	/**
//	 * Sets the active.
//	 *
//	 * @param active the new active
//	 */
//	public void setActive(Integer active) {
//		this.active = active;
//	}
//
//	/**
//	 * To string.
//	 *
//	 * @return the string
//	 */
////	@Override
////	public String toString() {
////		return "UserEntity [userId=" + userId + ", title=" + title + ", firstName=" + firstName + ", lastName="
////				+ lastName + ", emailId=" + emailId + ", dob=" + dob + ", roleId=" + roleId + ", employeeId=" + employeeId
////				+ ", contactNo=" + contactNo + ", password=" + password + ", active=" + active + "]";
////	}
//	
		
	
	

}
