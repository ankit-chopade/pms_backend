package com.pms.controller;


import java.security.Principal;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.common.entity.ApiResponse;
import com.pms.common.util.ResponseUtil;
import com.pms.entity.MenuEntity;
import com.pms.entity.UserEntity;
import com.pms.entity.UserRequest;
import com.pms.entity.UserResponse;
import com.pms.service.MenuService;
import com.pms.service.UserService;
import com.pms.util.JwtUtil;



@RestController
@RequestMapping("")
@CrossOrigin(origins="http://localhost:4200/")
public class HomeController {
	
	 @Autowired
 	 UserService service;
	
	 @Autowired
	 private JwtUtil jwtUtil; 
	 
     @Autowired
	 private AuthenticationManager authenticationManager;
     
     @Autowired
     private JavaMailSender mailSender;
     
     @Autowired
     private MenuService menuService;
	
	@GetMapping("check")
	public String check() {
		return "Checked";
	}
	
	
	   //user registration API 
	   @PostMapping("/registration")
	   public ResponseEntity<ApiResponse> registerEmp(@RequestBody UserEntity user){
		  ResponseEntity<ApiResponse> id= service.saveUser(user);
	      String body= "user " +id+ " saved ";
	      
	    //Send mail to registered user    
	      String recipient = user.getEmailId();
	      String subject   = "PMS Registration.";
	      String message   ="<HTML><head><body>"
	    		  
	    		  
	    		            +"<div style=' border:black ; padding :10px ; border-style:outset ;'>"
	    		            +"<h2>Welcome to the PMS Application.</h2><hr>"
	    		            +"<h3> Hello " + user.getTitle() + " " + user.getFirstName() +" "+ user.getLastName()
	    		            +"</h3> </br>"
	    		            +"<p> Welcome to the PMS Application : </br>"
	    		            +"your registration has been successfully completed."
	    		            +"</div>"
	    		            +"<HTML><head><body>";
	      //send mail
	      this.sendMail(recipient,subject,message);
	      
	      
	      return ResponseUtil.getResponse(HttpStatus.OK,"registration completed Successfully ",body);
	      
	   }
	 // Validate user and generate token (login)
	   @PostMapping("/login")
	   public ResponseEntity<ApiResponse> loginUser(@RequestBody UserRequest request){
		  
		   //validate username and passoword with database
		 authenticationManager.authenticate(
				           new UsernamePasswordAuthenticationToken(request.getEmailId(),request.getPassword()));		
	    String token =jwtUtil.generateToken(request.getEmailId());
	    
	    return ResponseUtil.getResponse(HttpStatus.OK,"token generated Successfully ",token);
	    		
	   }
	   
	//Menu  API
	   @PostMapping("menus")
		public ResponseEntity<ApiResponse> getMenus(@RequestBody MenuEntity menu){
			return this.menuService.getMenusByRoleId(menu.getRoleId());

		}
	   
	   
	   //after login only
	   @PostMapping("/welcome")
	   public ResponseEntity<String> accessData(Principal p){
		   return ResponseEntity.ok("Hello User !  "+ p.toString());
	   }
	   
	   
	  //send mail method for registered user 
	   private void sendMail(String recipient , String subject, String message){
		   
		   mailSender.send(new MimeMessagePreparator() {

				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
				  MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);	
				                    helper.setTo(recipient);
				                    helper.setSubject(subject);
				                    helper.setText(message,true);
				}			   
		   });
	   }
	   
	   
	   

	
}
