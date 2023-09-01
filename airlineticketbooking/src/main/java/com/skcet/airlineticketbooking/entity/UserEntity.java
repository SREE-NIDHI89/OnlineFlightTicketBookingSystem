package com.skcet.airlineticketbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

@Entity

public class UserEntity {
  
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	private String userMailId;
	@Transient
	private String userPassword;
	
	//getters and setters 
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
	public String getUserMailId() {
		return userMailId;
	}
	public void setUserMailId(String userMailId) {
		this.userMailId = userMailId;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	//Constructors
	public UserEntity(int userId, String userName, String userMailId, String userPassword) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userMailId = userMailId;
		this.userPassword = userPassword;
	}
	public UserEntity() {
		super();
	}
	
	
	
}
