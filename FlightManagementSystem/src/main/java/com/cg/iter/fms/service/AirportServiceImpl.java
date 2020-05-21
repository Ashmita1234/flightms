package com.cg.iter.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.fms.dto.Airport;
import com.cg.iter.fms.repository.AirportRepository;

@Service
public class AirportServiceImpl implements AirportService
{

@Autowired
private AirportRepository airportRepository;


	@Override
	public List<Airport> viewAllAirport() {
		return airportRepository.findAll();
	}

	@Override
	public Airport viewAirport(String airportCode) {
		 if(airportRepository.findByAirportCode(airportCode).isPresent()){
	            return airportRepository.findByAirportCode(airportCode).get();
	        }
	        return null;
	}

	@Override
	public Airport addAirport(Airport airport) {
		return airportRepository.save(airport);
	}

}
