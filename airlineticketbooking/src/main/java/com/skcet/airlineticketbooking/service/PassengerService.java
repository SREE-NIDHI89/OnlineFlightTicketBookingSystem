package com.skcet.airlineticketbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcet.airlineticketbooking.entity.PassengerEntity;
import com.skcet.airlineticketbooking.repository.PassengerRepository;


@Service
public class PassengerService {
	@Autowired
	
	private PassengerRepository passengerRepository;
	
	public PassengerEntity getPassenger(int passengerId) {
		Optional<PassengerEntity> optional=passengerRepository.findById(passengerId);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public PassengerEntity create(PassengerEntity passenger) {
	    return passengerRepository.save(passenger);
		 
		}
	
	public List<PassengerEntity> getAllPassengers(){
		return passengerRepository.findAll();
	}
	
	public void updatePassenger(PassengerEntity passenger) {
		passengerRepository.save(passenger);
		
	}
	
	public void deletePassenger(int passengerId) {
		Optional<PassengerEntity> optional = passengerRepository.findById(passengerId);
		if(!optional.isEmpty()) {
			passengerRepository.delete(optional.get());
		}
	}



}
