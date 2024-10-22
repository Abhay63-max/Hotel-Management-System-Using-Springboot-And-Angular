package com.abhaynoor.Hotel_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhaynoor.Hotel_Management_System.model.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Long>{

}
