package com.cg.iter.fms.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookingId;

    @OneToOne
    private User user;

    @NotNull(message = "Date should be in dd/mm/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/mm/yyyy")
    private Date bookingDate;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Passenger> passengerList;

    private Double ticketCost;
    private Double totalTicketCost;

    @OneToOne
    private Flight flight;

    private Integer noPassenger;

    public Booking() {
    }

    public Booking(Long bookingId, User user, @NotNull(message = "Date should be in dd/mm/yyyy") Date bookingDate,
			List<Passenger> passengerList, Double ticketCost, Double totalTicketCost, Flight flight,
			Integer noPassenger) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.bookingDate = bookingDate;
		this.passengerList = passengerList;
		this.ticketCost = ticketCost;
		this.totalTicketCost = totalTicketCost;
		this.flight = flight;
		this.noPassenger = noPassenger;
	}


    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    public void setPassengerList(List<Passenger> passengerList) {
        this.passengerList = passengerList;
    }

    public Double getTicketCost() {
        return ticketCost;
    }

    public void setTicketCost(Double ticketCost) {
        this.ticketCost = ticketCost;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", user=" + user + ", bookingDate=" + bookingDate
				+ ", passengerList=" + passengerList + ", ticketCost=" + ticketCost + ", totalTicketCost="
				+ totalTicketCost + ", flight=" + flight + ", noPassenger=" + noPassenger + "]";
	}

	public Integer getNoPassenger() {
        return noPassenger;
    }

    public void setNoPassenger(Integer noPassenger) {
        this.noPassenger = noPassenger;
    }

	public Double getTotalTicketCost() {
		return totalTicketCost;
	}

	public void setTotalTicketCost(Double totalTicketCost) {
		this.totalTicketCost = totalTicketCost;
	}
    
}
