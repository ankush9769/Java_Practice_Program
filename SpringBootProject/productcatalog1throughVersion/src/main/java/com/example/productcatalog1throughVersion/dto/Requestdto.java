package com.example.productcatalog1throughVersion.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Requestdto {
    @NotBlank(message = "name field should not blank")
    private String name;

    @NotBlank(message = "category field should not blank")
    private String category;

    @NotNull(message = "price should not null")
    @Positive(message = "enter positive number only")
    private Double price;

    @NotNull(message = "stock shold not be null")
    @PositiveOrZero(message = "enter positive and zero value")
    private Integer stock;
}
