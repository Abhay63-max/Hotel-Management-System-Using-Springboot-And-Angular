package com.abhaynoor.Hotel_Management_System.dto;

import java.util.Date;

import com.abhaynoor.Hotel_Management_System.enumeration.ReservationStatus;

public class ReservationDto {

	private Long userId;
	private Long roomId;
	private Date checkInDate;
	private Date checkOutDate;
	private ReservationStatus reservationStaus;
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public ReservationStatus getReservationStaus() {
		return reservationStaus;
	}
	public void setReservationStaus(ReservationStatus reservationStaus) {
		this.reservationStaus = reservationStaus;
	}
	
	}
