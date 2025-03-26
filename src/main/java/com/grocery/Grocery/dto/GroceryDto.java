package com.grocery.Grocery.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GroceryDto {

    private Long id;

    private String name;
    private String category;
    private Double price;
    private long quantity;
}
