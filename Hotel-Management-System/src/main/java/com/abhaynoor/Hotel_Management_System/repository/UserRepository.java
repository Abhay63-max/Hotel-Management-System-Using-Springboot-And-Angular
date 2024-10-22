package com.abhaynoor.Hotel_Management_System.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhaynoor.Hotel_Management_System.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByNameOrEmail(String name,String email);

	
}
