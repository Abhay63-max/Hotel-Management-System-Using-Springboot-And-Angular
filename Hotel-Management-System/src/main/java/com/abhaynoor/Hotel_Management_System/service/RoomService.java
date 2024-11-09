package com.abhaynoor.Hotel_Management_System.service;

import java.util.List;

import com.abhaynoor.Hotel_Management_System.dto.RoomDto;
import com.abhaynoor.Hotel_Management_System.model.Room;

public interface RoomService {

	List<Room> getAllRoomsInHotel(Long hotelId);
	void addRoom(RoomDto roomDto);
	void deleteRoomFromHotel(Long hotelId,Long roomId);
	//void roomBooked();
}
