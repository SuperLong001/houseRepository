package com.ssm.bean;

import java.util.List;

/**
 * 高级查询的条件类
 * @author 小龙
 * @time 2020-1-7
 */
public class AdvancedQueryCondition {
	
	private int district;
	
	private int street;
	
	private int room;
	
	private int hall;
	
	private int house_type;
	
	private double max_price;
	
	private double min_price;
	
	private List<Integer> house_types;
	
	public List<Integer> getHouse_types() {
		return house_types;
	}

	public void setHouse_types(List<Integer> house_types) {
		this.house_types = house_types;
	}

	private int release_time;

	public int getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	public int getStreet() {
		return street;
	}

	public void setStreet(int street) {
		this.street = street;
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

	public double getMax_price() {
		return max_price;
	}

	public void setMax_price(double max_price) {
		this.max_price = max_price;
	}

	public double getMin_price() {
		return min_price;
	}

	public void setMin_price(double min_price) {
		this.min_price = min_price;
	}


	public int getRelease_time() {
		return release_time;
	}

	public void setRelease_time(int release_time) {
		this.release_time = release_time;
	}
	
	
}
