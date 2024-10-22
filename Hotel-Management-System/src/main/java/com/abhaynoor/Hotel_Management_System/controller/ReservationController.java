package com.abhaynoor.Hotel_Management_System.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abhaynoor.Hotel_Management_System.dto.ReservationDto;
import com.abhaynoor.Hotel_Management_System.service.ReservationService;

@Controller
@RequestMapping("/api")
public class ReservationController {

	private final ReservationService reservationService;
	
	public ReservationController(ReservationService reservationService) {
		this.reservationService= reservationService;
	}
	@PostMapping("/makereservation")
	public ResponseEntity<String> makeReservation(@RequestBody ReservationDto reservationDto){
		reservationService.makeReservation(reservationDto);
		return new ResponseEntity<>("Reservation Successful",HttpStatus.OK);
	}
	
}
