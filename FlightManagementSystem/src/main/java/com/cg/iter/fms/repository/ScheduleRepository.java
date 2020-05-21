package com.cg.iter.fms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.iter.fms.dto.Airport;
import com.cg.iter.fms.dto.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer>{
	List<Schedule> findBySourceAirportAndDestinationAirport(Airport sourceAirport, Airport destinationAirport);


}
