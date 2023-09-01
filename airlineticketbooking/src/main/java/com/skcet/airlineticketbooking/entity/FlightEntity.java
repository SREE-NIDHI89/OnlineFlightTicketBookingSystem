package com.skcet.airlineticketbooking.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="flight_entity")
public class FlightEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	 
	//attributes
	private long flightId;
	private String flightName;
	private int flightCapacity;
	private String flightGroup;
	private String destination;
	
//	    //OnetoOne mapping
//		@OneToOne(cascade = CascadeType.ALL)
//		private PassengerEntity passenger;
	
		
		//OneToMany
		@OneToMany(cascade=CascadeType.ALL)
		@JoinColumn(name="fk_id")
		private List<PassengerEntity> passengerEntity;
		
		
	
	//getter and setters
	public long getFlightId() {
		return flightId;
	}
	public void setFlightId(long flightId) {
		this.flightId = flightId;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public int getFlightCapacity() {
		return flightCapacity;
	}
	public void setFlightCapacity(int flightCapacity) {
		this.flightCapacity = flightCapacity;
	}
	public String getFlightGroup() {
		return flightGroup;
	}
	public void setFlightGroup(String flightGroup) {
		this.flightGroup = flightGroup;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	//constructors
	public FlightEntity(long flightId, String flightName, int flightCapacity, String flightGroup, String destination) {
		super();
		this.flightId = flightId;
		this.flightName = flightName;
		this.flightCapacity = flightCapacity;
		this.flightGroup = flightGroup;
		this.destination = destination;
	}
	public FlightEntity() {
		super();
	}
	
	
//	//getters and setters for Passenger
//	public PassengerEntity getPassenger() {
//		return passenger;
//	}
//	public void setPassenger(PassengerEntity passenger) {
//		this.passenger = passenger;
//	}
	
	
	
	
	//getters and setters for passengerEntity
	public List<PassengerEntity> getPassengerEntity() {
		return passengerEntity;
	}
	public void setPassengerEntity(List<PassengerEntity> passengerEntity) {
		this.passengerEntity = passengerEntity;
	}
	
}
