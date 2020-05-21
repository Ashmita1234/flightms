package com.cg.iter.fms.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigInteger;

@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long pnrNumber;

    private String passengerName;

    private Integer passengerAge;

    private Long passengerUIN;

    private Double luggage;

    public Passenger() {

    }

    public Passenger(String passengerName, Integer passengerAge, Long passengerUIN, Double luggage) {
        this.passengerName = passengerName;
        this.passengerAge = passengerAge;
        this.passengerUIN = passengerUIN;
        this.luggage = luggage;
    }

    public Long getPnrNumber() {
        return pnrNumber;
    }

    public void setPnrNumber(Long pnrNumber) {
        this.pnrNumber = pnrNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public Integer getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(Integer passengerAge) {
        this.passengerAge = passengerAge;
    }

    public Long getPassengerUIN() {
        return passengerUIN;
    }

    public void setPassengerUIN(Long passengerUIN) {
        this.passengerUIN = passengerUIN;
    }

    public Double getLuggage() {
        return luggage;
    }

    public void setLuggage(Double luggage) {
        this.luggage = luggage;
    }

	@Override
	public String toString() {
		return "Passenger [pnrNumber=" + pnrNumber + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerUIN=" + passengerUIN + ", luggage=" + luggage + "]";
	}
}
