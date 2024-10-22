package com.abhaynoor.Hotel_Management_System.service.impl;

import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.abhaynoor.Hotel_Management_System.dto.UserDto;
import com.abhaynoor.Hotel_Management_System.model.User;
import com.abhaynoor.Hotel_Management_System.enumeration.Role;
import com.abhaynoor.Hotel_Management_System.repository.UserRepository;
import com.abhaynoor.Hotel_Management_System.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	
	public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository=userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	public void registerUser(UserDto userDto) {
		User user= new User();
		user.setId(user.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setRoles(Set.of(Role.CUSTOMER));
		userRepository.save(user);
	}
	
		
}
