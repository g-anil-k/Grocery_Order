package com.grocery.Grocery.dto;

import com.grocery.Grocery.entity.CustomerEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDto {

    private Long id;

    private LocalDate orderDate;
    private double totalPrice;
    private CustomerDto customerOrder;
    private Set<GroceryDto> groceryDto;
}
