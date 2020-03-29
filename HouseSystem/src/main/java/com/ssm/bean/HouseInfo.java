package com.ssm.bean;

import java.io.Serializable;

public class HouseInfo implements Serializable{
	
	private int house_id;
	
	private String house_title;

	private int house_district;
	
	private int house_street;
	
	private double rental_price;
	
	private int room;

	private int hall;
	
	private int house_type;

	private String contacts_phone;
	
	private String contacts_name;
	
	private String house_description;

	private int user_id;
	
	private String release_time;

	public void println() {
		System.out.println(house_id+":"+house_title+":"+house_district+":"+house_street+":"+rental_price+":"+room
		+hall+":"+house_type+":"+contacts_phone+":"+contacts_name+":"+house_description+":"+user_id+":"+release_time);
	}
	
	public String getRelease_time() {
		return release_time;
	}
	
	public void setRelease_time(String release_time) {
		this.release_time = release_time;
	}
	
	public int getHouse_id() {
		return house_id;
	}
	public void setHouse_id(int house_id) {
		this.house_id = house_id;
	}
	public String getHouse_title() {
		return house_title;
	}
	public void setHouse_title(String house_title) {
		this.house_title = house_title;
	}
	public int getHouse_district() {
		return house_district;
	}
	public void setHouse_district(int house_district) {
		this.house_district = house_district;
	}
	public int getHouse_street() {
		return house_street;
	}
	public void setHouse_street(int house_street) {
		this.house_street = house_street;
	}
	public double getRental_price() {
		return rental_price;
	}
	public void setRental_price(double rental_price) {
		this.rental_price = rental_price;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
	public int getHall() {
		return hall;
	}
	public void setHall(int hall) {
		this.hall = hall;
	}
	
	public int getHouse_type() {
		return house_type;
	}

	public void setHouse_type(int house_type) {
		this.house_type = house_type;
	}

	public String getContacts_phone() {
		return contacts_phone;
	}
	public void setContacts_phone(String contacts_phone) {
		this.contacts_phone = contacts_phone;
	}
	public String getContacts_name() {
		return contacts_name;
	}
	public void setContacts_name(String contacts_name) {
		this.contacts_name = contacts_name;
	}
	public String getHouse_description() {
		return house_description;
	}
	public void setHouse_description(String house_description) {
		this.house_description = house_description;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
}
