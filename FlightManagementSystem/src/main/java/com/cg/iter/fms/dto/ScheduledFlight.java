package com.cg.iter.fms.dto;

import javax.persistence.*;

@Entity
public class ScheduledFlight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Flight flight;

    private Integer availableSeats;

    @OneToOne(cascade = {CascadeType.ALL})
    private Schedule schedule;

    public ScheduledFlight() {
    }

    public ScheduledFlight(Flight flight, Integer availableSeats, Schedule schedule) {
        this.flight = flight;
        this.availableSeats = availableSeats;
        this.schedule = schedule;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
