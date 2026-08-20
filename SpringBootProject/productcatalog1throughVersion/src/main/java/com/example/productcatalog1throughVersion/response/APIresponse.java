package com.example.productcatalog1throughVersion.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class APIresponse<T> {
    private  boolean success;
    private String message;
    private T data;
}
