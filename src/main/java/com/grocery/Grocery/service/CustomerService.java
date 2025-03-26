package com.grocery.Grocery.service;

import com.grocery.Grocery.dto.CustomerDto;

import java.util.List;

public interface CustomerService {
    CustomerDto getCustomerById(Long id);

    List<CustomerDto> getAllCustomers();

    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto updateCustomer(Long id, CustomerDto customerDto);

    Boolean deleteCustomerById(Long id);
}
