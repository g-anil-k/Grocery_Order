package com.grocery.Grocery.service;

import com.grocery.Grocery.dto.OrderDto;
import com.grocery.Grocery.entity.OrderEntity;
import com.grocery.Grocery.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final ModelMapper modelMapper;

    public OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper) {
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OrderDto> getAllOrders() {
        List<OrderEntity> orders = orderRepository.findAll();
        return orders.stream()
                .map(orderEntity -> modelMapper.map(orderEntity,OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        OrderEntity entity = modelMapper.map(orderDto,OrderEntity.class);
        return modelMapper.map(orderRepository.save(entity),OrderDto.class);
    }

    @Override
    public Optional<OrderDto> getOrderById(Long id) {
        return Optional.ofNullable(modelMapper.map(orderRepository.findById(id),OrderDto.class));
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        OrderEntity entity = modelMapper.map(orderDto,OrderEntity.class);
        entity.setId(id);
        return modelMapper.map(orderRepository.save(entity),OrderDto.class);
    }

    @Override
    public Boolean deleteOrderById(Long id) {
        if(orderRepository.existsById(id)){
            orderRepository.deleteById(id);
            return  true;
        }
        return false;
    }
}
