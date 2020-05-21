package com.cg.iter.fms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.iter.fms.dto.Booking;
import com.cg.iter.fms.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserService userService;
    

	@Override
	public Booking addBooking(Booking booking)
	{
		
		booking.setTotalTicketCost(booking.getTicketCost()*booking.getNoPassenger());
		 return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> viewBooking(Long userId) {
		if (userService.viewUser(userId) != null) {
            return bookingRepository.findAll().stream()
                    .filter(x -> x.getUser().getUserId() == userId)
                    .collect(Collectors.toCollection(ArrayList::new));
        }
        return null;
	}

	@Override
	public List<Booking> viewBooking() {
		return bookingRepository.findAll();
	}

	@Override
	public Booking modifyBooking(Booking booking) {
		  if (bookingRepository.findById(booking.getBookingId()).isPresent()) {
	            Booking tempBooking = bookingRepository.findById(booking.getBookingId()).get();
	            tempBooking.setBookingDate(booking.getBookingDate());
	            tempBooking.setPassengerList(booking.getPassengerList());
	            tempBooking.setNoPassenger(booking.getNoPassenger());
	            tempBooking.setTotalTicketCost(booking.getTicketCost()*booking.getNoPassenger());
	            bookingRepository.save(tempBooking);
	            return tempBooking;
	        }
	        return null;
	    }

	@Override
	public void deleteBooking(Long bookingid) {
		if(bookingRepository.findById(bookingid).isPresent())
		{
            bookingRepository.deleteById(bookingid);
		
	}
	}

	@Override
	public Booking viewBookingByBookingId(Long bookingid) {
		if(bookingRepository.findById(bookingid).isPresent())
            return bookingRepository.findById(bookingid).get();
        return null;
	}

	

}

