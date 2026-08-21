package com.example.flightBookingSystmeSBapp10.service;

import com.example.flightBookingSystmeSBapp10.dto.RequestDTO;
import com.example.flightBookingSystmeSBapp10.entity.FlightTickets;
import com.example.flightBookingSystmeSBapp10.exception.ResourceNotFoundException;
import com.example.flightBookingSystmeSBapp10.repo.FlightRepo;
import com.example.flightBookingSystmeSBapp10.response.APIresponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    FlightRepo flightRepo;

    @Override
    public FlightTickets createTicket(RequestDTO request) {
        FlightTickets flightTickets = new FlightTickets();
        flightTickets.setFlightno(request.getFlightno());
        flightTickets.setPassangername(request.getPassangername());
        flightTickets.setTraveldate(request.getTraveldate());
        FlightTickets response =  flightRepo.save(flightTickets);
        return response;
    }

    @Override
    @Cacheable(value = "flight",key = "#id")
    public FlightTickets getById(Long id){
        return flightRepo.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Ticket not found"));
    }

    @Override
    public List<FlightTickets> getAll() {
        return flightRepo.findAll();
    }

    @Override
    @CacheEvict(value = "flight",key = "#id")
    public void deleteById(Long id) {
        flightRepo.deleteById(id);
    }

    @Override
    @CachePut(value = "flight",key = "#id")
    public FlightTickets updateById(Long id, RequestDTO request) {
        FlightTickets newticket = getById(id);
        newticket.setFlightno(request.getFlightno());
        newticket.setPassangername(request.getPassangername());
        newticket.setTraveldate(request.getTraveldate());

        return newticket;
    }


}
