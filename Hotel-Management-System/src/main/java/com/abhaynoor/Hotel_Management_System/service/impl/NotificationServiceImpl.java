package com.abhaynoor.Hotel_Management_System.service.impl;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.abhaynoor.Hotel_Management_System.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	private final JavaMailSender mailSender;
	private final SimpleMailMessage mailMessage;
	
	public NotificationServiceImpl(JavaMailSender mailSender,SimpleMailMessage mailMessage) {
		this.mailSender = mailSender;
		this.mailMessage=mailMessage;
		}
	
	@Override
	public void sendEmailOnReservation(String to, String subject, String message) {
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		mailSender.send(mailMessage);
		
	}

}
