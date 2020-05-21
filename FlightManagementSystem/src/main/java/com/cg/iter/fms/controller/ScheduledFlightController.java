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

import com.cg.iter.fms.Pojo.ScheduleFlightUpdate;
import com.cg.iter.fms.Pojo.SearchScheduleFlight;
import com.cg.iter.fms.dto.ScheduledFlight;
import com.cg.iter.fms.service.ScheduledFlightService;


@RestController
public class ScheduledFlightController {

    @Autowired
    private ScheduledFlightService scheduleFlightService;

    @PostMapping(value = "/scheduleFlight")
    private ScheduledFlight saveScheduleFlight(@RequestBody ScheduledFlight scheduledFlight){
        return scheduleFlightService.saveScheduleFlight(scheduledFlight);
    }

    @GetMapping(value = "/scheduleFlight")
    private List<ScheduledFlight> viewScheduleFlight(){
        return scheduleFlightService.viewScheduledFlight();
    }

    @GetMapping(value = "/searchScheduleFlight")
    private List<ScheduledFlight> viewScheduledFlights(@RequestBody SearchScheduleFlight searchScheduleFlight){
        return scheduleFlightService.viewScheduledFlights(searchScheduleFlight.getAirports().get(0),
                searchScheduleFlight.getAirports().get(1), searchScheduleFlight.getLocalDate());
    }

    @GetMapping(value = "/scheduleFlight/{flightno}")
    private List<ScheduledFlight> viewScheduleFlight(@PathVariable(value = "flightno") Long flightno){
        return scheduleFlightService.viewScheduledFlights(flightno);
    }

    @PutMapping(value = "/scheduleFlight/{scheduleId}")
    private ScheduledFlight modifyScheduleFlight(@RequestBody ScheduleFlightUpdate scheduleFlightUpdate){
        ScheduledFlight scheduledFlight = scheduleFlightService.modifyScheduledFlight(scheduleFlightUpdate.getFlight(),
                scheduleFlightUpdate.getSchedule(), scheduleFlightUpdate.getId());
        return scheduledFlight == null ? new ScheduledFlight() : scheduledFlight ;
    }
    
    @DeleteMapping(value = "/scheduleFlight/{scheduleFlightId}")
    private void deleteScheduleFlight(@PathVariable(value = "scheduleFlightId") Integer scheduleFlightId){
        scheduleFlightService.deleteScheduledFlight(scheduleFlightId);
    }

}