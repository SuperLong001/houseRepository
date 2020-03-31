package com.yidu.bean;

import java.util.List;

public class UserInfo {
	
	
	
	private int userId;
	private String userName;
	private String userPass;
	private List<Integer> number;
	
	
	public List<Integer> getNumber() {
		return number;
	}
	public void setNumber(List<Integer> number) {
		this.number = number;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
	public UserInfo(int userId, String userName, String userPass) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPass = userPass;
	}
	
	public UserInfo() {
		super();
	}
	
	
}
