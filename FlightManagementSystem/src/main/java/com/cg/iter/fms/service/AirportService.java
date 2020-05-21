package com.cg.iter.fms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.iter.fms.dto.Airport;
import com.cg.iter.fms.dto.Booking;

@Service
public interface AirportService {
	
	Airport addAirport(Airport airport);

	List<Airport> viewAllAirport();

	Airport viewAirport(String airpotCode);

}
