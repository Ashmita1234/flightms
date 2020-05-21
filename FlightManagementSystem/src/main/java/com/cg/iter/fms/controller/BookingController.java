package com.cg.iter.fms.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.iter.fms.dto.Booking;
import com.cg.iter.fms.exception.NullParameterException;
import com.cg.iter.fms.exception.UserNotFoundException;
import com.cg.iter.fms.repository.UserRepository;
import com.cg.iter.fms.service.BookingService;

@CrossOrigin(origins = "*")
@RestController
public class BookingController { 
	
	DateFormat df = new SimpleDateFormat("dd/MM/yy");
    Date dateobj = new Date();

    @Autowired
    private BookingService bookingService;

    @PostMapping(value = "/booking")
    private Booking addBooking(@RequestBody Booking booking)throws UserNotFoundException, NullParameterException
    {
    	
    	if(booking.getUser().getUserType().isEmpty() || booking.getUser().getUserName().isEmpty() 
    			 )
    	{
    		 throw new UserNotFoundException("user not found");
    	}
    	
    	else if(booking.getUser().getEmail().isEmpty())
    	{
       		 throw new NullParameterException("email not mentioned");
       	}
    	
    	else if(booking.getBookingDate().before(dateobj))
    	{
       		 throw new NullParameterException("date cannot be accepted");
    	}
    	//System.out.println("booking:"+booking);
        return bookingService.addBooking(booking);

    }

    @GetMapping(value = "/booking/user/{id}")
    private List<Booking> viewBookingByUser(@PathVariable(value = "id") Long userId)throws NullParameterException
    {
    	
    	List<Booking> booking=bookingService.viewBooking(userId);
    	if(null==booking || "".equals(booking))
    	{
    		 throw new NullParameterException("booking not found for user id "+userId);
    	}
        return bookingService.viewBooking(userId);
    }

    @GetMapping(value = "/booking")
    private List<Booking> viewBooking(){
        return bookingService.viewBooking();
    }

    @PutMapping(value = "/booking")
    private Booking modifyBooking(@RequestBody Booking booking)
    {
    	Booking booking1=bookingService.viewBookingByBookingId(booking.getBookingId());
    	if(null==booking1 || "".equals(booking1))
    	{
    		 throw new NullParameterException("booking not found with id "+booking.getBookingId());
    	}
    	
    	
        return bookingService.modifyBooking(booking);
    }
    
    
    @GetMapping(value = "/booking/{id}")
    private Booking viewBookingByBookingId(@PathVariable(value = "id")Long bookingid)throws NullParameterException
    {
    	Booking booking=bookingService.viewBookingByBookingId(bookingid);
    	if(null==booking || "".equals(booking))
    	{
    		 throw new NullParameterException("booking not found with id "+bookingid);
    	}
    	else
    	{
    		return bookingService.viewBookingByBookingId(bookingid);
		}
    }
    
    
    

    @DeleteMapping(value = "/booking/{id}")
    private void deleteBooking(@PathVariable(value = "id") Long bookingid)throws NullParameterException
    {
    	Booking booking=bookingService.viewBookingByBookingId(bookingid);
    	if(null==booking || "".equals(booking))
    	{
    		 throw new NullParameterException("booking not found with booking id "+bookingid);
    	}
        bookingService.deleteBooking(bookingid);
    }
}  