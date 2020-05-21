package com.cg.iter.fms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.fms.dto.Airport;
import com.cg.iter.fms.dto.Flight;
import com.cg.iter.fms.dto.Schedule;
import com.cg.iter.fms.dto.ScheduledFlight;
import com.cg.iter.fms.repository.AirportRepository;
import com.cg.iter.fms.repository.FlightRepository;
import com.cg.iter.fms.repository.ScheduleFlightRepository;
import com.cg.iter.fms.repository.ScheduleRepository;

@Service
public class ScheduleFlightServiceImpl implements ScheduledFlightService {

    @Autowired
    private ScheduleFlightRepository scheduleFlightRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private AirportRepository airportRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public ScheduledFlight saveScheduleFlight(ScheduledFlight scheduledFlight) {
        return scheduleFlightRepository.save(scheduledFlight);
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlights(Airport toAirport, Airport fromAirport, Date date) {
        List<ScheduledFlight> scheduleFlightList = new ArrayList<>();
        if(airportRepository.findById(toAirport.getId()).isPresent() && airportRepository.findById(fromAirport.getId()).isPresent()){
             List<Schedule> scheduleList = scheduleRepository.findBySourceAirportAndDestinationAirport(toAirport,fromAirport);
             for(Schedule schedule : scheduleList){
            	 Timestamp d = (Timestamp)schedule.getArrivalTime();
                 if(new Date(d.getTime()).equals(date)){
                     if(scheduleFlightRepository.findBySchedule(schedule).isPresent())
                        scheduleFlightList.add(scheduleFlightRepository.findBySchedule(schedule).get());
                 }
             }
        }
        return scheduleFlightList;
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlights(Long flightno) {
        List<ScheduledFlight> scheduleFlightList = new ArrayList<>();
        if(flightRepository.findById(flightno).isPresent()){
            Flight flight = flightRepository.findById(flightno ).get();
            scheduleFlightList.addAll(scheduleFlightRepository.findByFlight(flight));
        }
        return scheduleFlightList;
    }

    @Override
    public List<ScheduledFlight> viewScheduledFlight() {
        return scheduleFlightRepository.findAll();
    }

    @Override
    public ScheduledFlight modifyScheduledFlight(Flight flight, Schedule schedule, Integer id) {
        if(scheduleFlightRepository.findById(id).isPresent()){
            ScheduledFlight scheduledFlight = scheduleFlightRepository.findById(id).get();
            scheduledFlight.setFlight(flight);
            scheduledFlight.setSchedule(schedule);
            return scheduleFlightRepository.save(scheduledFlight);
        }
        return null;
    }

    @Override
    public void deleteScheduledFlight(Integer id) {
        scheduleFlightRepository.deleteById(id);
    }

    

	
}