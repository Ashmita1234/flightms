package com.cg.iter.fms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.iter.fms.dto.Flight;
import com.cg.iter.fms.dto.Schedule;
import com.cg.iter.fms.dto.ScheduledFlight;
import com.cg.iter.fms.dto.User;

public interface ScheduleFlightRepository extends JpaRepository<ScheduledFlight, Integer>
{

	 ScheduledFlight save(ScheduledFlight scheduledFlight);
	Optional<ScheduledFlight> findBySchedule(Schedule schedule);

    List<ScheduledFlight> findByFlight(Flight flight);
}
