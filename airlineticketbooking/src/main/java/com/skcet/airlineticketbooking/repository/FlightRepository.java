package com.skcet.airlineticketbooking.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.skcet.airlineticketbooking.entity.FlightEntity;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity,Long>{
   
	    //JPQL 
	
	    @Query("select f from FlightEntity f")
	   public List<FlightEntity> getAllFlightsUsingJPQL();
	   
	    
	    @Transactional
		@Modifying
		@Query(value="UPDATE flight_entity SET flightCapacity = :flightCapacity WHERE flightName = :flightName",nativeQuery = true)
		Integer updateFlightByName(int flightCapacity, String flightName);

	    
//	    @Transactional
//		@Modifying
//		@Query("DELETE FROM PassengerEntity WHERE passengerName= :passengerName")
//		Integer deleteByName(String passengerName);
	    
	  
}

      