package com.cg.iter.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.fms.dto.Flight;
import com.cg.iter.fms.repository.FlightRepository;


@Service
public class FlightServiceImpl implements FlightService
{
	@Autowired
	private FlightRepository flightrepository;

	@Override
	public Flight addFlight(Flight flight) {
		return flightrepository.save(flight);
	}

	@Override
	public Flight viewFlightByFlightNo(Long flightno) {
		if(flightrepository.findById(flightno).isPresent())
		{
			return flightrepository.findById(flightno).get();
		}
		else
		{
			return null;
		}
	}

	@Override
	public List<Flight> viewFlight() {
		return flightrepository.findAll();
	}

	@Override
	public Flight modifyFlight(Flight flight) {
		if(flightrepository.findById(flight.getFlightno()).isPresent())
		{
			Flight tempFlight=flightrepository.findById(flight.getFlightno()).get();
			tempFlight.setFlightModel(flight.getFlightModel());
			tempFlight.setSeatCapacity(flight.getSeatCapacity());
			flightrepository.save(tempFlight);
		}
		return null;
	}

	@Override
	public void deleteFlight(Long flightno) {
		if(flightrepository.findById(flightno).isPresent())
		{
			flightrepository.deleteById(flightno);
		}
		
	}

}
