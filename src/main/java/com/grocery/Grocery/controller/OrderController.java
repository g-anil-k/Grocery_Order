package com.grocery.Grocery.controller;

import com.grocery.Grocery.dto.OrderDto;
import com.grocery.Grocery.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<OrderDto>> getOrderById(@PathVariable Long id){
        Optional<OrderDto> orderDto = orderService.getOrderById(id);
        if(orderDto.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(orderDto);
    }

    @PostMapping
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto){
        return ResponseEntity.ok(orderService.createOrder(orderDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto){

        return ResponseEntity.ok(orderService.updateOrder(id,orderDto));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteOrderById(@PathVariable Long id){
        Boolean result = orderService.deleteOrderById(id);
    }












}
