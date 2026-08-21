package com.example.flightBookingSystmeSBapp10.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RequestDTO {
    @NotBlank(message = "flight number cant be blank")
    private String flightno;

    @NotBlank(message = "passanger name cant be blank")
    private String passangername;

    @NotNull(message = "travel date cant be blank")
    private Date traveldate;
}
