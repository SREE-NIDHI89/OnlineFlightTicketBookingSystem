package com.skcet.airlineticketbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcet.airlineticketbooking.entity.PassengerEntity;
import com.skcet.airlineticketbooking.service.PassengerService;


@RestController
@RequestMapping("/apimap")
public class PassengerController {
	@Autowired
	public PassengerService passengerService;
	
	@GetMapping("/{passengerId}")
	public ResponseEntity<PassengerEntity> getUser(@PathVariable int passengerId) {
		PassengerEntity passenger= passengerService.getPassenger(passengerId);
		if (passenger == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(passenger);
	}
	
	@PostMapping("/postpassenger")
	public PassengerEntity addPassenger(@RequestBody PassengerEntity passenger) {
		return passengerService.create(passenger);
	}
	
	@GetMapping("/getpassenger")
	public ResponseEntity<List<PassengerEntity>> getAllPassengers(){
		List<PassengerEntity> passenger = passengerService.getAllPassengers();
		return ResponseEntity.status(HttpStatus.OK).body(passenger);
	}

	@PutMapping("/putpassenger")
	public ResponseEntity<String> updatePassenger(@RequestBody PassengerEntity passenger) {
		passengerService.updatePassenger(passenger);
		return ResponseEntity.ok("Updated");
	}
	
	
	@DeleteMapping("/deletepassenger")
	public ResponseEntity<String> deletePassenger(@RequestBody PassengerEntity passenger) {
		passengerService.deletePassenger(passenger.getPassengerId());
		return ResponseEntity.ok("Deleted");
	}


}
