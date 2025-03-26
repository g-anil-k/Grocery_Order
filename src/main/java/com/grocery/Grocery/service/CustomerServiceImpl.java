package com.grocery.Grocery.service;

import com.grocery.Grocery.dto.CustomerDto;
import com.grocery.Grocery.entity.CustomerEntity;
import com.grocery.Grocery.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{


    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository,ModelMapper modelMapper){
        this.modelMapper = modelMapper;
        this.customerRepository = customerRepository;
    }
    @Override
    public CustomerDto getCustomerById(Long id) {
        CustomerEntity customer = customerRepository.findById(id).orElse(null);
        return modelMapper.map(customer,CustomerDto.class);
    }



        @Override
        public List<CustomerDto> getAllCustomers () {
        List<CustomerEntity> customerList = customerRepository.findAll();
        return customerList.stream()
                .map(customer -> modelMapper.map(customer, CustomerDto.class))
                .collect(Collectors.toList());
    }

        @Override
        public CustomerDto createCustomer (CustomerDto customerDto){
        CustomerEntity entity = modelMapper.map(customerDto, CustomerEntity.class);
        return modelMapper.map(customerRepository.save(entity), CustomerDto.class);
    }

        @Override
        public CustomerDto updateCustomer(Long id,CustomerDto customerDto){
        CustomerEntity entity = customerRepository.findById(id).orElse(null);
        if(entity == null) {
            CustomerEntity newEntity = modelMapper.map(customerDto,CustomerEntity.class);
            newEntity.setId(id);
            return modelMapper.map(customerRepository.save(newEntity),CustomerDto.class);
        }
        modelMapper.map(customerDto,entity);
        entity.setId(id);
        return modelMapper.map(customerRepository.save(entity),CustomerDto.class);
    }

    @Override
    public Boolean deleteCustomerById(Long id) {
        if(customerRepository.existsById(id)) {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
