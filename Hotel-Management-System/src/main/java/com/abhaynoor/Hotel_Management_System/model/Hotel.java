package com.abhaynoor.Hotel_Management_System.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Hotel {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String location;
	private String description;
	private String imageUrl;
	@OneToMany(mappedBy="hotel",cascade= {CascadeType.PERSIST,CascadeType.MERGE},orphanRemoval= true,fetch=FetchType.LAZY)
	private Set<Room> rooms= new HashSet<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
		this.imageUrl= imageUrl;
	}
	public Set<Room> getRooms(){
		return rooms;
	}
	public void setRooms(Set<Room> rooms) {
		this.rooms=rooms;	
	}
	// Helper method to maintain bi-directional relationship
	public void addRoom(Room room) {
		this.rooms.add(room);
		room.setHotel(this);
	}
	
}
