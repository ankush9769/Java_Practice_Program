package com.example.flightBookingSystmeSBapp10.repo;

import com.example.flightBookingSystmeSBapp10.entity.FlightTickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<FlightTickets,Long> {
}
