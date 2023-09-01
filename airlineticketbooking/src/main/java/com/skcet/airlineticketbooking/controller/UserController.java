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

import com.skcet.airlineticketbooking.entity.UserEntity;
import com.skcet.airlineticketbooking.service.UserService;

@RestController
@RequestMapping("/apimapping")
public class UserController {
   
	@Autowired
	public UserService userService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserEntity> getUser(@PathVariable int userId) {
		UserEntity user= userService.getUser(userId);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PostMapping("/postuser")
	public UserEntity addProduct(@RequestBody UserEntity user) {
		return userService.create(user);
	}
	
	@GetMapping("/getuser")
	public ResponseEntity<List<UserEntity>> getAllUsers(){
		List<UserEntity> user = userService.getAllUser();
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}

	@PutMapping("/putuser")
	public ResponseEntity<String> updateUser(@RequestBody UserEntity user) {
		userService.updateUser(user);
		return ResponseEntity.ok("Updated");
	}
	
	
	@DeleteMapping("/deleteuser")
	public ResponseEntity<String> deleteUser(@RequestBody UserEntity user) {
		userService.deleteUser(user.getUserId());
		return ResponseEntity.ok("Deleted");
	}


	

}
