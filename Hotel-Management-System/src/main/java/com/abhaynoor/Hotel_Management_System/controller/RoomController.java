package com.abhaynoor.Hotel_Management_System.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhaynoor.Hotel_Management_System.dto.RoomDto;
import com.abhaynoor.Hotel_Management_System.model.Room;
import com.abhaynoor.Hotel_Management_System.service.RoomService;

@RestController
@RequestMapping("/api")
public class RoomController {

	private final RoomService roomService;
	
	public RoomController(RoomService roomService) {
		this.roomService=roomService;
	}
	@GetMapping("/rooms/{hotelId}")
	public List<Room> getAllRoomsInHotel(@PathVariable Long hotelId){
		return roomService.getAllRoomsInHotel(hotelId);
	}
	@PostMapping("/addroom")
	public ResponseEntity<String> addRoom(@RequestBody RoomDto roomDto){
		roomService.addRoom(roomDto);
		return new ResponseEntity<>("Room added successfully",HttpStatus.OK);
	}
	@DeleteMapping("/deleteroom/{hotelId}/{roomId}")
	public ResponseEntity<String> deleteRoomFromHotel(@PathVariable Long hotelId,@PathVariable Long roomId){
		roomService.deleteRoomFromHotel(hotelId, roomId);
		return new ResponseEntity<>("Room deleted",HttpStatus.OK);
	}
}
