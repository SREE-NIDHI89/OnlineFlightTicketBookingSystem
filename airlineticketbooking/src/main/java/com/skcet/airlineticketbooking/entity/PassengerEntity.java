package com.skcet.airlineticketbooking.entity;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PassengerEntity {
   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
    private int passengerId;
    private String passengerName;
	private String passengerContact;
	private String passengerAddress;
	private String passengerMail;
	private String passengerUsername;
	private String passengerPassword;
	private  int passengerAge;
	
	//getters and setters
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerContact() {
		return passengerContact;
	}
	public void setPassengerContact(String passengerContact) {
		this.passengerContact = passengerContact;
	}
	public String getPassengerAddress() {
		return passengerAddress;
	}
	public void setPassengerAddress(String passengerAddress) {
		this.passengerAddress = passengerAddress;
	}
	public String getPassengerMail() {
		return passengerMail;
	}
	public void setPassengerMail(String passengerMail) {
		this.passengerMail = passengerMail;
	}
	public String getPassengerUsername() {
		return passengerUsername;
	}
	public void setPassengerUsername(String passengerUsername) {
		this.passengerUsername = passengerUsername;
	}
	public String getPassengerPassword() {
		return passengerPassword;
	}
	public void setPassengerPassword(String passengerPassword) {
		this.passengerPassword = passengerPassword;
	}
	public int getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(int passengerAge) {
		this.passengerAge = passengerAge;
	}
	
	//constructors
	public PassengerEntity(int passengerId, String passengerName, String passengerContact, String passengerAddress,
			String passengerMail, String passengerUsername, String passengerPassword, int passengerAge) {
		super();
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerContact = passengerContact;
		this.passengerAddress = passengerAddress;
		this.passengerMail = passengerMail;
		this.passengerUsername = passengerUsername;
		this.passengerPassword = passengerPassword;
		this.passengerAge = passengerAge;
	}
	public PassengerEntity() {
		super();
	}
	
	
	
	
   
}
