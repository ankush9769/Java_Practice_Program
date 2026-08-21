package com.example.flightBookingSystmeSBapp10.controller;

import com.example.flightBookingSystmeSBapp10.dto.RequestDTO;
import com.example.flightBookingSystmeSBapp10.entity.FlightTickets;
import com.example.flightBookingSystmeSBapp10.response.APIresponse;
import com.example.flightBookingSystmeSBapp10.service.FlightServiceImpl;
import com.example.flightBookingSystmeSBapp10.service.IdempotencyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class FlightController {
    @Autowired
    FlightServiceImpl flightService;

    @Autowired
    IdempotencyService idempotencyService;

    @PostMapping("/booking")
    public ResponseEntity<APIresponse<FlightTickets>> createTicket(
            @Valid
            @RequestHeader("Idempotency-key")String idempotencyKey,
            @RequestBody RequestDTO request)
    {
        if(idempotencyService.isProcessed(idempotencyKey)){
            Long existingProductId = idempotencyService.getProductId(idempotencyKey);
            FlightTickets existingProduct = flightService.getById(existingProductId);

            APIresponse<FlightTickets> response = APIresponse.<FlightTickets>builder()
                    .success(true)
                    .message("ticket booking are already processed")
                    .data(existingProduct)
                    .build();
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(response);
        }
        FlightTickets flightTickets = flightService.createTicket(request);
        idempotencyService.store(
                idempotencyKey,
                flightTickets.getId()
        );
        APIresponse<FlightTickets> apIresponse = APIresponse.<FlightTickets>builder()
                .success(true)
                .message("ticked booked !!")
                .data(flightTickets)
                .build();

        return ResponseEntity.ok(apIresponse);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<APIresponse<FlightTickets>> getById(@PathVariable Long id){
        FlightTickets flightTickets = flightService.getById(id);
        APIresponse<FlightTickets> apIresponse = APIresponse.<FlightTickets>builder()
                .success(true)
                .message("Ticket found !!")
                .data(flightTickets)
                .build();
        return ResponseEntity.ok(apIresponse);
    }

    @GetMapping("/getall")
    public ResponseEntity<APIresponse<List<FlightTickets>>> getAll(){
        List<FlightTickets> listresponse =  flightService.getAll();
        APIresponse<List<FlightTickets>> apIresponse= APIresponse.<List<FlightTickets>>builder()
                .success(true)
                .message("all ticket found !!")
                .data(listresponse)
                .build();
        return ResponseEntity.ok().body(apIresponse);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<APIresponse<FlightTickets>> deleteById(@PathVariable Long id){
        flightService.deleteById(id);
        APIresponse<FlightTickets> apIresponse = APIresponse.<FlightTickets>builder()
                .success(true)
                .message("ticket deleted successfully")
                .data(null)
                .build();
        return ResponseEntity.ok(apIresponse);
    }

    @PutMapping("/updateById/{id}")
    public ResponseEntity<APIresponse<FlightTickets>> updateById(
            @Valid
            @RequestBody RequestDTO request,
            @PathVariable Long id
    )
    {
        FlightTickets updateTicket =  flightService.updateById(id,request);
        APIresponse<FlightTickets> apIresponse = APIresponse.<FlightTickets>builder()
            .success(true)
            .message("update successfully")
            .data(updateTicket)
            .build();
        
        return ResponseEntity.ok(apIresponse);
    }

}
