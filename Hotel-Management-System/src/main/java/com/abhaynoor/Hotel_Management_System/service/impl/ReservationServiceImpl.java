package com.abhaynoor.Hotel_Management_System.service.impl;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.abhaynoor.Hotel_Management_System.dto.ReservationDto;
import com.abhaynoor.Hotel_Management_System.enumeration.ReservationStatus;
import com.abhaynoor.Hotel_Management_System.event.ReservationMadeEvent;
import com.abhaynoor.Hotel_Management_System.model.Reservation;
import com.abhaynoor.Hotel_Management_System.model.Room;
import com.abhaynoor.Hotel_Management_System.model.User;
import com.abhaynoor.Hotel_Management_System.repository.ReservationRepository;
import com.abhaynoor.Hotel_Management_System.repository.RoomRepository;
import com.abhaynoor.Hotel_Management_System.repository.UserRepository;
import com.abhaynoor.Hotel_Management_System.service.NotificationService;
import com.abhaynoor.Hotel_Management_System.service.ReservationService;

import jakarta.transaction.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	private final ReservationRepository reservationRepository;
	private final RoomRepository roomRepository;
	private final UserRepository userRepository;
	private final ApplicationEventPublisher eventPublisher;
	
	public ReservationServiceImpl(ReservationRepository reservationRepository,RoomRepository roomRepository,UserRepository userRepository,ApplicationEventPublisher eventPublisher) {
		this.reservationRepository= reservationRepository;
		this.roomRepository = roomRepository;
		this.userRepository=userRepository;
		this.eventPublisher=eventPublisher;
	}

	@Override
	@Transactional
	public void makeReservation(ReservationDto reservationDto) {
		Reservation reservation = new Reservation();
		Room room = roomRepository.findById(reservationDto.getRoomId()).orElseThrow(()->new RuntimeException("Room not available"));
		User user = userRepository.findById(reservationDto.getUserId()).orElseThrow(()-> new RuntimeException("User not found"));
		
		if(room.isAvailable()) {
			reservation.setUser(user);
			reservation.setRoom(room);
			reservation.setCheckInDate(reservationDto.getCheckInDate());
			reservation.setCheckOutDate(reservationDto.getCheckOutDate());
			reservation.setReservationStatus(ReservationStatus.BOOKED);
			reservationRepository.save(reservation);
			eventPublisher.publishEvent(new ReservationMadeEvent(this,user,room,reservationDto));
			room.setAvailable(false);
			roomRepository.save(room);
		}
		
	}

}
