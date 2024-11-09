package com.abhaynoor.Hotel_Management_System.service;

public interface NotificationService {

	void sendEmailOnReservation(String to,String subject,String message);
}
