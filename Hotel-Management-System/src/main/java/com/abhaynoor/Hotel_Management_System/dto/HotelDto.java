package com.abhaynoor.Hotel_Management_System.dto;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class HotelDto {

	@NotNull
	@NotEmpty(message="Name cannot be empty")
	private String name;
	@NotNull
	@NotEmpty(message="Location cannot be empty")
	private String location;
	@NotNull
	@NotEmpty(message="Description cannot be empty")
	private String description;
	@NotNull
	@NotEmpty(message="Image cannot be empty")
	private String imageUrl;
	
	private List<RoomDto> rooms;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public List<RoomDto> getRooms() {
		return rooms;
	}
	public void setRooms(List<RoomDto> rooms) {
		this.rooms = rooms;
	}
	
}
