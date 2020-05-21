package com.cg.iter.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.fms.dto.Flight;
import com.cg.iter.fms.dto.User;
import com.cg.iter.fms.service.FlightService;

@RestController
public class FlightController 
{
	@Autowired
	FlightService flightService;
	
	 @PostMapping(value = "/flight")
	    private Flight addFlight(@RequestBody Flight flight){
	        return flightService.addFlight(flight);
	    }

	    @GetMapping(value = "/flight/{id}")
	    private Flight viewFlightByFlightNo(@PathVariable(value = "id") Long flightno){
	        return flightService.viewFlightByFlightNo(flightno);
	    }

	    @GetMapping(value = "/flight")
	    private List<Flight> viewFlight(){
	        return flightService.viewFlight();
	    }

	    @PutMapping(value = "/flight/{id}")
	    private Flight modifyFlight(@PathVariable(value = "id")Long flightno, @RequestBody Flight flightDetailsToUpdate){
	    	Flight flight = flightService.viewFlightByFlightNo(flightno);
	    	if(flight != null)
	    		return flightService.modifyFlight(flightDetailsToUpdate);
	    	return null;
	    }
	    
	    @DeleteMapping(value = "/flight/{id}")
	    private void deleteFlight(@PathVariable(value = "id") Long flightno){
	    	flightService.deleteFlight(flightno);
	    }
	}  