package com.skcet.airlineticketbooking.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skcet.airlineticketbooking.entity.FlightEntity;
import com.skcet.airlineticketbooking.repository.FlightRepository;

import com.skcet.airlineticketbooking.service.FlightService;

@RestController
@RequestMapping(path="/api")
public class FlightController {
	Logger logger = LoggerFactory.getLogger(FlightController.class);
	@Autowired
	private FlightService flightService;
//	@Autowired
//	private FlightRepository flightRepository;

	@PostMapping(path="/saveflight")
	public FlightEntity saveFlights(@RequestBody FlightEntity f) {
		return flightService.saveFlights(f);
	}
	
	//Pagination and Sorting
	
	@GetMapping(path="/getpage")
	public ResponseEntity<Page<FlightEntity>> getFlightsByField(@RequestParam String field,@RequestParam int pageNo,@RequestParam int pageSize){
		Page<FlightEntity> flights=flightService.getFlightsByField(field, pageNo, pageSize);
		return ResponseEntity.ok(flights);
	}
	
	
	
	
//	@GetMapping("/path/{variable}")
//	public String pathVariable(@PathVariable String variable) {
//		return variable;
//	}
	
//	@GetMapping("/request")
//	public String requestParam(@RequestParam String name) {
//		return name;
//	}
	
	
	//CRUD operation
	
	@GetMapping("/{flightId}")
	public ResponseEntity<FlightEntity> getFlight(@PathVariable Long flightId) {
		FlightEntity flight = flightService.getFlight(flightId);
		if (flight == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(flight);
	}
	
	
//	@PostMapping(path="/post")
//	public ResponseEntity<Long> addFlight(@RequestBody FlightEntity f) {
//		Long flightId = flightService.addFlight(f);
//		return ResponseEntity.status(HttpStatus.CREATED).body(flightId);
//	}
	

	
	
	@PutMapping(path="/put")
	public ResponseEntity<String> updateBook(@RequestBody FlightEntity f) {
		flightService.updateFlight(f);
		return ResponseEntity.ok("Updated");
	}
	
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteFlight(@RequestBody FlightEntity f) {
		flightService.deleteFlight(f.getFlightId());
		return ResponseEntity.ok("Deleted");
	}
	
	@DeleteMapping("/delete/{flightId}")
	public ResponseEntity<String> deleteById(@PathVariable long flightId) {
	   flightService.deleteById(flightId);
	   return ResponseEntity.ok("Deleted Flight "+flightId);
	}
	
	//JPQL
	
	@GetMapping("/getFlightsUsingJPQL")
	public List<FlightEntity> getAllFlightsUsingJPQL(){
		return flightService.getAllFlightsUsingJPQL();
	}

	@PutMapping("/flights/update/{flightCapacity}/{flightName}")
	public ResponseEntity<String> updateFlightByName(@PathVariable int flightCapacity, @PathVariable String flightName) {
		return new ResponseEntity<String>(flightService.updateFlightByName(flightCapacity, flightName)+" record(s) updated.", HttpStatus.OK);
	}
	
//	@DeleteMapping("/passengers/delete/{passengerName}")
//	public ResponseEntity<String> deleteByName(@PathVariable String passengerName) {
//		return new ResponseEntity<String>(flightService.deleteByName(passengerName)+" record(s) deleted", HttpStatus.OK);
//	}
	
	
	@GetMapping(path="/get")
	public ResponseEntity<List<FlightEntity>> getAllFlights(){
		List<FlightEntity> flight = flightService.getAllFlights();
		return ResponseEntity.status(HttpStatus.OK).body(flight);
	}
	
     
	@GetMapping(path="/loggerdemo")
	public String loggerDemo() {
		logger.info("Logger info");
		logger.warn("Logger warn");
		logger.error("logger error");
		return "Hello from logger demo";
	}
	
	
}
