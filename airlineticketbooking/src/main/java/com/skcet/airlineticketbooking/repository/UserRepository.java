package com.skcet.airlineticketbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.skcet.airlineticketbooking.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

}
