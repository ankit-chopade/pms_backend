package com.pms.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.pms.entity.UserEntity;

@Service
public class TokenService {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;
	
	public String generateTokens(UserEntity user ,String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmailId(), password));
		return jwtUtil.generateToken(user);
	}

}
