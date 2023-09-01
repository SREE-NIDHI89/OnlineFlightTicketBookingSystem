package com.skcet.airlineticketbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skcet.airlineticketbooking.entity.UserEntity;
import com.skcet.airlineticketbooking.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	
	private UserRepository userRepository;
	
	//CRUD 
	public UserEntity getUser(int userId) {
		Optional<UserEntity> optional=userRepository.findById(userId);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}

	public UserEntity create(UserEntity user) {
	    return userRepository.save(user);
		 
		}
	
	public List<UserEntity> getAllUser(){
		return userRepository.findAll();
	}
	
	public void updateUser(UserEntity user) {
		userRepository.save(user);
		
	}
	
	public void deleteUser(int userId) {
		Optional<UserEntity> optional = userRepository.findById(userId);
		if(!optional.isEmpty()) {
			userRepository.delete(optional.get());
		}
	}
	
}
