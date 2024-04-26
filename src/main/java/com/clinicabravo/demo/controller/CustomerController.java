package com.clinicabravo.demo.controller;

import com.clinicabravo.demo.dto.CustomerDto;
import com.clinicabravo.demo.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    //Build a Customer REST API
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto savedCustomer = customerService.createCustomer(customerDto);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }

    //Build a Get Customer REST API
    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long customerId){
        CustomerDto customerDto = customerService.getCustomerById(customerId);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    //Build Get All Customers REST API
    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        List<CustomerDto> customers = customerService.getAllCustomers();
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    //Build Update Customer REST API
    @PutMapping("{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") Long customerId,
                                                      @RequestBody CustomerDto updatedCustomer ){
        CustomerDto customerDto = customerService.updateCustomer(customerId, updatedCustomer);
        return new ResponseEntity<>(customerDto, HttpStatus.OK);
    }

    //Build Delete Customer REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<>("Customer deleted successfully!", HttpStatus.OK);
    }
}
