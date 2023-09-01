package com.skcet.airlineticketbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.skcet.airlineticketbooking.entity.FlightEntity;
import com.skcet.airlineticketbooking.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	public FlightEntity saveFlights(FlightEntity f) {
		return flightRepository.save(f);
	}
	
	//Pagination and Sorting
	
	public Page<FlightEntity> getFlightsByField(String field,int pageNo,int pageSize){
		Sort sort=Sort.by(field);
		Pageable pageable=PageRequest.of(pageNo, pageSize, sort);
		return flightRepository.findAll(pageable);
	}
	
	
	
	//CRUD operation
	public FlightEntity getFlight(Long flightId) {
		Optional<FlightEntity> optional=flightRepository.findById(flightId);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

//	public Long addFlight(FlightEntity f){
//		FlightEntity save=flightRepository.save(f);
//		return save.getFlightId();
//		}
	public List<FlightEntity> getAllFlights(){
		return flightRepository.findAll();
	}
	
	
	public void updateFlight(FlightEntity f) {
		flightRepository.save(f);
		
	}
	
	public void deleteFlight(Long flightId) {
		Optional<FlightEntity> optional = flightRepository.findById(flightId);
		if(!optional.isEmpty()) {
		  flightRepository.delete(optional.get());
		}
	}
	
	public void deleteById(Long flightId) {
		Optional<FlightEntity> optional=flightRepository.findById(flightId);
		if(!optional.isEmpty()) {
			
		
		   flightRepository.delete(optional.get());
		}
	}
	
	//JPQL
	
	public List<FlightEntity> getAllFlightsUsingJPQL(){
		return flightRepository.getAllFlightsUsingJPQL();
	}

	
	public ResponseEntity<String> updateFlightByName(@PathVariable int flightCapacity, @PathVariable String flightName) {
		return new ResponseEntity<String>(flightRepository.updateFlightByName(flightCapacity, flightName)+" record(s) updated.", HttpStatus.OK);
	}

//	public ResponseEntity<String> deleteByName(@PathVariable String passengerName) {
//		return new ResponseEntity<String>(flightRepository.deleteByName(passengerName)+" record(s) deleted", HttpStatus.OK);
//	}
//	
	

	
	
}
