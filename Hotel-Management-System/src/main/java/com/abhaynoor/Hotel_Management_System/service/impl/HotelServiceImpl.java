package com.abhaynoor.Hotel_Management_System.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.abhaynoor.Hotel_Management_System.dto.HotelDto;
import com.abhaynoor.Hotel_Management_System.dto.RoomDto;
import com.abhaynoor.Hotel_Management_System.model.Hotel;
import com.abhaynoor.Hotel_Management_System.model.Room;
import com.abhaynoor.Hotel_Management_System.repository.HotelRepository;
import com.abhaynoor.Hotel_Management_System.service.HotelService;
import com.abhaynoor.Hotel_Management_System.service.ImageUploadService;

@Service
public class HotelServiceImpl implements HotelService{

	private final HotelRepository hotelRepository;
	private final ImageUploadService imageUploadService;
	
	public HotelServiceImpl(HotelRepository hotelRepository,ImageUploadService imageUploadService) {
		this.hotelRepository=hotelRepository;
		this.imageUploadService=imageUploadService;
	}
	@Override
	public void addHotel(HotelDto hotelDto,MultipartFile image) throws IOException {
		
		String imageUrl = imageUploadService.uploadImage(image);
		
		Hotel hotel = new Hotel();
		hotel.setId(hotel.getId());
		hotel.setName(hotelDto.getName());
		hotel.setLocation(hotelDto.getLocation());
		hotel.setDescription(hotelDto.getDescription());
		hotel.setImageUrl(imageUrl);
		
		for(RoomDto roomDto:hotelDto.getRooms()) {
			Room room = new Room();
			room.setRoomNumber(roomDto.getRoomNumber());
			room.setPrice(roomDto.getPrice());
			room.setType(roomDto.getType());
			room.setAvailable(true);
			room.setHotel(hotel);
			hotel.getRooms().add(room);
		}
		
		hotelRepository.save(hotel);
		
	}
	@Override
	public List<Hotel> getAllHotel() {
		return hotelRepository.findAll();
	}
	@Override
	public void updateHotel(HotelDto hotelDto,Long id) {
		Hotel hotel = getById(id);
		hotel.setId(id);
		hotel.setName(hotelDto.getName());
		hotel.setLocation(hotelDto.getLocation());
		hotel.setDescription(hotelDto.getDescription());
		hotel.setImageUrl(hotelDto.getImageUrl());
		hotelRepository.save(hotel);
	}
	@Override
	public void deleteHotel(Long id) {
		Hotel hotel = getById(id);
		hotelRepository.delete(hotel);
		}
	private Hotel getById(Long id) {
		return hotelRepository.findById(id).orElseThrow(()->new RuntimeException("Hotel not found"));
	}
}
