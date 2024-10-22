package com.abhaynoor.Hotel_Management_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhaynoor.Hotel_Management_System.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long>{

}
