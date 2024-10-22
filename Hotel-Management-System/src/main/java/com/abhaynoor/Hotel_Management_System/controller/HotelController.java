package com.abhaynoor.Hotel_Management_System.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.abhaynoor.Hotel_Management_System.dto.HotelDto;
import com.abhaynoor.Hotel_Management_System.model.Hotel;
import com.abhaynoor.Hotel_Management_System.service.HotelService;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

	private final HotelService hotelService;
	
	public HotelController(HotelService hotelService) {
		this.hotelService=hotelService;
	}
	@PostMapping(value="/addhotel", consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<String> addHotel(@ModelAttribute HotelDto hotelDto , @RequestParam("file") MultipartFile image) throws IOException{
		hotelService.addHotel(hotelDto,image);
		return new ResponseEntity<>("Hotel added Successfully",HttpStatus.OK);
	}
	@GetMapping("/allhotels")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> hotels = hotelService.getAllHotel();
		return new ResponseEntity<>(hotels,HttpStatus.OK);
	}
	@PatchMapping("/updatehotel/{id}")
	public ResponseEntity<String> updateHotel(@RequestBody HotelDto hotelDto,@PathVariable Long id){
		hotelService.updateHotel(hotelDto, id);
		return new ResponseEntity<>("Hotel updated successfully",HttpStatus.OK);
	}
	@DeleteMapping("/deletehotel/{id}")
	public ResponseEntity<String> deleteHotel(@PathVariable Long id){
		hotelService.deleteHotel(id);
		return new ResponseEntity<>("Hotel deleted successfully",HttpStatus.OK);
	}
}
