package com.pms.management.services;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.pms.management.constants.ManagementConstants;
import com.pms.management.converter.UserConverter;
import com.pms.management.dto.ChangePasswordDto;
import com.pms.management.dto.UserDetailsViewDto;
import com.pms.management.dto.UserDto;
import com.pms.management.entites.UserEntity;
import com.pms.management.repository.ManagementRepository;
import com.pms.management.utils.CustomException;
import com.pms.management.utils.MailService;

import net.bytebuddy.utility.RandomString;

public class MangamentServiceImpl {//implements ManagementService{
   
	/*
	 * @Autowired private ManagementRepository repository;
	 * 
	 * @Autowired private MailService mailService;
	 * 
	 * @Autowired private UserConverter userConverter;
	 * 
	 * @Override public UserDto saveUser(UserDto userDto) throws CustomException {
	 * 
	 * if (repository.findByEmailId(userDto.getEmailId()).isPresent()) { throw new
	 * CustomException(HttpStatus.NOT_FOUND, "Email id already exist"); } try {
	 * UserEntity userEntity = userConverter.toEntity(userDto);
	 * //userEntity.setPassword(pwdEncoder.encode(userDto.getPassword()));
	 * userEntity.setActiveStatus(ManagementConstants.ACTIVE_STATUS);
	 * userEntity.setCreatedDate(new Date()); UserEntity saveUser =
	 * repository.save(userEntity); mailService.sendMail(saveUser); return
	 * userConverter.toDto(saveUser); } catch (Exception ex) { throw new
	 * CustomException(HttpStatus.NOT_FOUND, "Issue while creating user"); } }
	 * 
	 * @Override public UserDto addUser(UserDto userDto) throws CustomException {
	 * 
	 * if (repository.findByEmailId(userDto.getEmailId()).isPresent()) { throw new
	 * CustomException(HttpStatus.NOT_FOUND, "Email id already exist"); } try {
	 * UserEntity userEntity = userConverter.toEntity(userDto); String
	 * default_password = "Password@123"; userDto.setPassword(default_password);
	 * //userEntity.setPassword(pwdEncoder.encode(userDto.getPassword()));
	 * userEntity.setActiveStatus(ManagementConstants.ACTIVE_STATUS);
	 * userEntity.setCreatedBy(1l); userEntity.setCreatedDate(new Date());
	 * UserEntity saveUser = repository.save(userEntity);
	 * mailService.sendMailToNewUser(saveUser,default_password); return
	 * userConverter.toDto(saveUser); } catch (Exception ex) { throw new
	 * CustomException(HttpStatus.NOT_FOUND, "Issue while creating user"); } }
	 * 
	 * @Override public List<UserEntity> getPatients() { List<UserEntity> patients =
	 * repository.findAll(); return patients.stream().filter(p -> p.getRoleId() ==
	 * 5).collect(Collectors.toList()); }
	 * 
	 * @Override public List<UserEntity> getHospitalUsers() {
	 * 
	 * List<UserEntity> patients = repository.findAll(); return
	 * patients.stream().filter(p -> p.getRoleId() == 3 || p.getRoleId() ==
	 * 4).collect(Collectors.toList()); }
	 * 
	 * @Override public UserEntity updateStatus(UserDto user) { if
	 * (repository.findByUserId(user.getUserId()).isPresent()) {
	 * 
	 * UserEntity entity = repository.findByUserId(user.getUserId()).get();
	 * entity.setActiveStatus(user.getActive());
	 * 
	 * this.sendMailForUpdateStatus(entity); return repository.save(entity); }
	 * 
	 * return null; }
	 * 
	 * @Override public UserDetailsViewDto findByEmailId(String emailId) throws
	 * CustomException { Optional<UserEntity> optional =
	 * repository.findByEmailId(emailId); if (optional.isPresent()) { UserEntity
	 * user = optional.get(); return new
	 * UserDetailsViewDto(userConverter.toDto(user)); } else { throw new
	 * CustomException(HttpStatus.NOT_FOUND, "Email id does not exist"); } }
	 * 
	 * 
	 * @Override public UserDetailsViewDto updatePassword(ChangePasswordDto dto)
	 * throws CustomException { Optional<UserEntity> optional =
	 * repository.findByEmailId(dto.getEmailId()); if (optional.isPresent()) {
	 * UserEntity user = optional.get(); if
	 * (pwdEncoder.matches(dto.getOldPassword(), user.getPassword())) {
	 * user.setPassword(pwdEncoder.encode(dto.getNewPassword()));
	 * user.setUpdatedDate(new Date()); UserEntity updatedUser =
	 * repository.save(user) ; // this.sendMailForUpdateStatus(updatedUser); return
	 * new UserDetailsViewDto(userConverter.toDto(updatedUser)); } else { throw new
	 * CustomException(HttpStatus.NOT_FOUND, "Invalid password"); } } else { throw
	 * new CustomException(HttpStatus.NOT_FOUND, "Invalid email id"); } }
	 * 
	 * public UserEntity findByUserId(Long userId) throws CustomException {
	 * Optional<UserEntity> optional = repository.findById(userId); if
	 * (optional.isPresent()) { return optional.get(); } else { throw new
	 * CustomException(HttpStatus.NOT_FOUND, "User detail does not exits"); } }
	 * 
	 * private void generateOneTimePassword(UserEntity user) { UserEntity userEntity
	 * = repository.findByEmailId(user.getEmailId()).get(); String otp =
	 * RandomString.make(8); String encodedOTP = pwdEncoder.encode(otp);
	 * userEntity.setPassword(encodedOTP); userEntity.setOtpRequestedTime(new
	 * Date()); repository.save(userEntity);
	 * mailService.sendMailToActiveUser(userEntity,otp); }
	 * 
	 * private void sendMailForUpdateStatus(UserEntity user){ String status= ""; if
	 * (user.getActiveStatus() == 1) { this.generateOneTimePassword(user); return; }
	 * else if (user.getActiveStatus() == 2) { status = "In-Active"; } else { status
	 * = "Blocked"; }
	 * 
	 * String recipient = user.getEmailId(); String subject = "PMS Registration.";
	 * String message = "<HTML><head><body>" +
	 * "<div style=' border:black ; padding :10px ; border-style:outset ;'>" +
	 * "<p> Welcome to the PMS Application : </br>" +user.getTitle()+ " " +
	 * user.getFirstName()+ " " + user.getLastName()
	 * +" your profile status is updated : </p>" + "<h3> <b>" + status +" </b></h3>"
	 * + "</div>" + "<HTML><head><body>"; ; mailService.sendMail(recipient, subject,
	 * message); }
	 */
}