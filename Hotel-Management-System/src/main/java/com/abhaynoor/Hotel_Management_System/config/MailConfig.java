package com.abhaynoor.Hotel_Management_System.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class MailConfig {

	@Bean
	public SimpleMailMessage simpleMailMessage() {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("noreply.hotel101management@gmail.com");
		return mailMessage;
	}
}
