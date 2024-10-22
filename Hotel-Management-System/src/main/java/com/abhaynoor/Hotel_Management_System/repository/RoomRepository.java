package com.abhaynoor.Hotel_Management_System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abhaynoor.Hotel_Management_System.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

	List<Room> findByHotelId(Long hotelId);
	//List<Room> isAvailableTrue();
}
