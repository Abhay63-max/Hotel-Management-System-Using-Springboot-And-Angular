package com.abhaynoor.Hotel_Management_System.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.abhaynoor.Hotel_Management_System.service.NotificationService;

@Component
public class ReservationMadeListener {
	
	private final NotificationService notificationService;
	
	public ReservationMadeListener(NotificationService notificationService) {
		this.notificationService=notificationService;
	}

	@EventListener
	public void onReservationMade(ReservationMadeEvent event) {
		notificationService.sendEmailOnReservation(event.getUser().getEmail(),"Reservation Confirmation","You have successfully made a booking in "+event.getRoom().getHotel().getName()+" from"+event.getReservationDto().getCheckInDate()+" to"+event.getReservationDto().getCheckOutDate());
	}
}
