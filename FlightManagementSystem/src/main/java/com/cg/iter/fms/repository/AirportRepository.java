package com.cg.iter.fms.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.iter.fms.dto.Airport;
import com.cg.iter.fms.dto.Booking;

public interface AirportRepository extends JpaRepository<Airport, Integer>{

	Airport save(Airport airport);
	Optional<Airport> findByAirportCode(String airportCode);

}
