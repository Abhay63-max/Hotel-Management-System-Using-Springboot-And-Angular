package com.abhaynoor.Hotel_Management_System.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.abhaynoor.Hotel_Management_System.dto.HotelDto;
import com.abhaynoor.Hotel_Management_System.model.Hotel;

public interface HotelService {

	void addHotel(HotelDto hotelDto,MultipartFile image) throws IOException;
	List<Hotel> getAllHotel();
	void updateHotel(HotelDto hotelDto,Long id);
	void deleteHotel(Long id);
}
