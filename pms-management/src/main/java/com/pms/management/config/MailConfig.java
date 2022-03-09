package com.pms.management.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {
	
	 @Value("${spring.mail.host}")
     private String host;
	 
	 @Value("${spring.mail.port}")
     private Integer port;
	 
	 @Value("${spring.mail.username}")
     private String username;
	 
	 @Value("${spring.mail.password}")
     private  String password;
	 
	
	 @Bean
	 public JavaMailSender javaMailService() {
		 JavaMailSenderImpl impl=new JavaMailSenderImpl();
		 impl.setHost(host);
		 impl.setPort(port);
		
		 impl.setUsername(username);
		
		 impl.setPassword(password);
		
		 impl.setJavaMailProperties(javaMailProperties());
		
	  return impl;				
	 }

	private Properties javaMailProperties() {
		Properties props=new Properties();
		props.setProperty("mail.transport.protocol","smtp");
		props.setProperty("mail.smtp.auth","true");
		props.setProperty("mail.smtp.starttls.enable","true");
		props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.setProperty("mail.debug","true");
		return props;
	}
}
