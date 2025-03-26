package com.grocery.Grocery.service;

import com.grocery.Grocery.dto.OrderDto;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<OrderDto> getAllOrders();

    OrderDto createOrder(OrderDto orderDto);

    Optional<OrderDto> getOrderById(Long id);
}
