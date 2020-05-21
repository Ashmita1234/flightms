package com.cg.iter.fms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.iter.fms.dto.Booking;
import com.cg.iter.fms.dto.Passenger;

@Service
public interface BookingService {

	Booking addBooking(Booking booking);

	List<Booking> viewBooking(Long userId);

	List<Booking> viewBooking();

	Booking modifyBooking(Booking booking);

	void deleteBooking(Long bookingid);

	Booking viewBookingByBookingId(Long bookingid);
	
}
