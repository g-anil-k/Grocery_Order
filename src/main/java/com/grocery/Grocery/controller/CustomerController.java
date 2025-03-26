package com.grocery.Grocery.controller;

import com.grocery.Grocery.dto.CustomerDto;
import com.grocery.Grocery.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable Long id){
        CustomerDto customer = (customerService.getCustomerById(id));
        if(customer==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customer);
        }
        return ResponseEntity.ok(customer);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return ResponseEntity.ok(customerService.getAllCustomers());
    }


    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        return ResponseEntity.ok(customerService.createCustomer(customerDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@RequestBody CustomerDto customerDto,@PathVariable Long id){
        CustomerDto updatedCustomer = customerService.updateCustomer(id,customerDto);
        if(customerDto == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(customerDto);
        }
        return ResponseEntity.ok(updatedCustomer);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCustomerById(@PathVariable Long id){
        Boolean deletion = customerService.deleteCustomerById(id);
        if(deletion){
            return ResponseEntity.ok().body(true);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
    }

}
