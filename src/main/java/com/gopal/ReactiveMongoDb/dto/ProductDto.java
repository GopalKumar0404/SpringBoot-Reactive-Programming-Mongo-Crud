package com.gopal.ReactiveMongoDb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDto {

    private String id;
    private String name;
    private double price;
    private int quantity;
}
