package com.example.flightBookingSystmeSBapp10.service;


import com.example.flightBookingSystmeSBapp10.dto.RequestDTO;
import com.example.flightBookingSystmeSBapp10.entity.FlightTickets;

import java.util.List;

public interface FlightService {
    public FlightTickets createTicket(RequestDTO request);

    public FlightTickets getById(Long Id);

    public List<FlightTickets> getAll();

    public void deleteById(Long id);

    public FlightTickets updateById(Long id , RequestDTO request);
}
