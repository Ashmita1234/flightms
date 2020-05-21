package com.cg.iter.fms.dto;

import javax.persistence.Entity;
import javax.persistence.*;
import java.math.BigInteger;

@Entity
public class Flight {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long flightno;

    private String carrierName;

    private String flightModel;

    private Integer seatCapacity;

    public Flight() {

    }

    @Override
	public String toString() {
		return "Flight [flightno=" + flightno + ", carrierName=" + carrierName + ", flightModel=" + flightModel
				+ ", seatCapacity=" + seatCapacity + "]";
	}

	public Flight(String carrierName, String flightModel, Integer seatCapacity) {
        this.carrierName = carrierName;
        this.flightModel = flightModel;
        this.seatCapacity = seatCapacity;
    }

    public Long getFlightno() {
        return flightno;
    }

    public void setFlightno(Long flightno) {
        this.flightno = flightno;
    }

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getFlightModel() {
        return flightModel;
    }

    public void setFlightModel(String flightModel) {
        this.flightModel = flightModel;
    }

    public Integer getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(Integer seatCapacity) {
        this.seatCapacity = seatCapacity;
    }
}
