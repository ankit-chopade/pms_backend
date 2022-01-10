package com.pms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.entity.UserEntity;
import com.pms.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserEntity validateUser(String name, String password) {
		Optional<UserEntity> optional = userRepo.findByFirstNameAndPassword(name, password);
		UserEntity user = null;
		if (optional.isPresent()) {
			user = optional.get();
			return user;
		
		}
		return null;
	}

}
