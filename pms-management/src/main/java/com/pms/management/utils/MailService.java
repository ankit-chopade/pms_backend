package com.pms.management.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.pms.management.entites.UserEntity;

@Service
public class MailService {

	@Autowired
	private JavaMailSender mailSender;


	public void sendMail(String recipient, String subject, String message) {
		mailSender.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
				helper.setTo(recipient);
				helper.setSubject(subject);
				helper.setText(message, true);
			}
		});
	}
	public void sendMail(UserEntity user) {
		String recipient = user.getEmailId();
		String subject = "PMS Registration.";
		String message = "<HTML><head><body>" + "<div style=' border:black ; padding :10px ; border-style:outset ;'>"
				+ "<h2>Welcome to the PMS Application.</h2><hr>" + "<h3> Hello " + user.getTitle() + " "
				+ user.getFirstName() + " " + user.getLastName() + "</h3> </br>"
				+ "<p> Welcome to the PMS Application : </br>" + "your registration has been successfully completed."
				+ "</div>" + "<HTML><head><body>";
		
		this.sendMail(recipient, subject, message);
	}
	public void sendMailToNewUser(UserEntity user,String default_password) {
		String recipient = user.getEmailId();
		String subject = "PMS Registration.";
		String message = "<HTML><head><body>" + "<div style=' border:black ; padding :10px ; border-style:outset ;'>"
				+ "<h2>Welcome to the PMS Application.</h2><hr>" + "<h3> Hello " + user.getTitle() + " "
				+ user.getFirstName() + " " + user.getLastName() + "</h3> </br>"
				+ "<p> Welcome to the PMS Application : </br>"
				+ "your registration has been successfully completed.</p>" + "<h3>your username : " + user.getEmailId()
				+ " </h3>" + "<h3>your default password : " + default_password + " </h3>"
				+ "this is one time login password please change your password." + "</div>" + "<HTML><head><body>";
		
		this.sendMail(recipient, subject, message);
	}
   public void sendMailToActiveUser(UserEntity user ,String otp) {
		String recipient = user.getEmailId();
		String subject = "PMS Registration.";
		String message = "<HTML><head><body>" + "<div style=' border:black ; padding :10px ; border-style:outset ;'>"
				+ "<p> Welcome to the PMS Application : </br>"				
				+user.getTitle()+ " " + user.getFirstName()+ " " + user.getLastName() +"</br>"
				+" your profile activated." +"</br>"
				+ "this is your one time login OTP </p>" + "<h3> <b>" + otp +" </b></h3>"				
				+ "</div>" + "<HTML><head><body>";
		
		this.sendMail(recipient, subject, message);
	}
   public void sendMailToForgotPasswordUser(UserEntity user,String default_password) {
		String recipient = user.getEmailId();
		String subject = "PMS Registration.";
		String message = "<HTML><head><body>" + "<div style=' border:black ; padding :10px ; border-style:outset ;'>"
				+ "<h2>Welcome to the PMS Application.</h2><hr>" + "<h3> Hello " + user.getTitle() + " "
				+ user.getFirstName() + " " + user.getLastName() + "</h3> </br>"
				+ "<p> Welcome to the PMS Application : </br>"
				+ "your password has been successfully reset.</p>" + "<h3>your username : " + user.getEmailId()
				+ " </h3>" + "<h3>your default password : " + default_password + " </h3>"
				+ "this is one time login password please change your password." + "</div>" + "<HTML><head><body>";
		
		this.sendMail(recipient, subject, message);
	}

	
	
	
}
