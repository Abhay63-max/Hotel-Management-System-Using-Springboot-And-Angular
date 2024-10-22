package com.abhaynoor.Hotel_Management_System.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abhaynoor.Hotel_Management_System.dto.RoomDto;
import com.abhaynoor.Hotel_Management_System.model.Hotel;
import com.abhaynoor.Hotel_Management_System.model.Room;
import com.abhaynoor.Hotel_Management_System.repository.HotelRepository;
import com.abhaynoor.Hotel_Management_System.repository.RoomRepository;
import com.abhaynoor.Hotel_Management_System.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	private final RoomRepository roomRepository;
	private final HotelRepository hotelRepository;
	
	public RoomServiceImpl(RoomRepository roomRepository,HotelRepository hotelRepository) {
		this.roomRepository=roomRepository;
		this.hotelRepository=hotelRepository;
	}
	@Override
	public List<Room> getAllRoomsInHotel(Long hotelId) {
		return roomRepository.findByHotelId(hotelId);
	}
	@Override
	public void addRoom(RoomDto roomDto) {
		Room room = new Room();
		room.setId(room.getId());
		room.setRoomNumber(roomDto.getRoomNumber());
		room.setPrice(roomDto.getPrice());
		room.setType(roomDto.getType());
		room.setAvailable(true);
		
		Hotel hotel = hotelRepository.findById(roomDto.getHotelId()).orElseThrow(()-> new RuntimeException("Hotel not found"));
		room.setHotel(hotel);
		roomRepository.save(room);
	}
	@Override
	@Transactional
	public void deleteRoomFromHotel(Long hotelId, Long roomId) {
		Hotel hotel= hotelRepository.findById(hotelId).orElseThrow(()-> new RuntimeException("Hotel not found"));
		Room room= roomRepository.findById(roomId).orElseThrow(()-> new RuntimeException("Room not found"));
		hotel.getRooms().remove(room);
		hotelRepository.save(hotel);
	}
	

}
