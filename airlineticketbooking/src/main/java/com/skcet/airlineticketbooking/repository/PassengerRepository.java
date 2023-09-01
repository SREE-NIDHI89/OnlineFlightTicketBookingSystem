package com.skcet.airlineticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skcet.airlineticketbooking.entity.PassengerEntity;

@Repository
public interface  PassengerRepository extends JpaRepository<PassengerEntity,Integer>{

}
