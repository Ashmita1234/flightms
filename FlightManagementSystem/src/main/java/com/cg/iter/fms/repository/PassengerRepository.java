package com.cg.iter.fms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cg.iter.fms.dto.Passenger;

@CrossOrigin("http://localhost:4200/")
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer>{

}
