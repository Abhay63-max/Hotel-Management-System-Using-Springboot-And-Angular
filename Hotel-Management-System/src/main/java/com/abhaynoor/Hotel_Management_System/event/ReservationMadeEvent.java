package com.abhaynoor.Hotel_Management_System.event;

import org.springframework.context.ApplicationEvent;

import com.abhaynoor.Hotel_Management_System.dto.ReservationDto;
import com.abhaynoor.Hotel_Management_System.model.Room;
import com.abhaynoor.Hotel_Management_System.model.User;

public class ReservationMadeEvent extends ApplicationEvent{
	
	private User user;
	private Room room;
	private ReservationDto reservationDto;

	public ReservationMadeEvent(Object source,User user,Room room,ReservationDto reservationDto) {
		super(source);
		this.user=user;
		this.room=room;
		this.reservationDto=reservationDto;
	}
	public User getUser() {
		return user;
	}
	public Room getRoom() {
		return room;
	}
	public ReservationDto getReservationDto() {
		return reservationDto;
	}
}
