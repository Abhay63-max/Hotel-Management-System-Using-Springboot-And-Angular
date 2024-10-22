package com.abhaynoor.Hotel_Management_System.dto;

public class RoomDto {

	private int roomNumber;
	private double price;
	private String type;
	private boolean available;
	private Long hotelId;
	
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public Long getHotelId() {
		return hotelId;
	}
	public void setHotel(Long hotelId) {
		this.hotelId = hotelId;
	}
	
	
}
