package com.cg.iter.fms.Pojo;

import com.cg.iter.fms.dto.Flight;
import com.cg.iter.fms.dto.Schedule;

public class ScheduleFlightUpdate {

    private  Integer id;

    private Schedule schedule;

    private Flight flight;

    public ScheduleFlightUpdate() {
    }

    public ScheduleFlightUpdate(Integer id, Schedule schedule, Flight flight) {
        this.id = id;
        this.schedule = schedule;
        this.flight = flight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
