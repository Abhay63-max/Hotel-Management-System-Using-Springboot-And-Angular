package com.abhaynoor.Hotel_Management_System.security;

import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.abhaynoor.Hotel_Management_System.model.User;
import com.abhaynoor.Hotel_Management_System.repository.UserRepository;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;
	
	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository=userRepository;
	}
	@Override
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userRepository.findByNameOrEmail(usernameOrEmail,usernameOrEmail)
				    .orElseThrow(()-> new UsernameNotFoundException("User not exist by email or username"));
		
		Set<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role-> new SimpleGrantedAuthority(role.name()))
				.collect(Collectors.toSet());
														
		return new org.springframework.security.core.userdetails.User(usernameOrEmail, user.getPassword(), authorities);
	}
}

