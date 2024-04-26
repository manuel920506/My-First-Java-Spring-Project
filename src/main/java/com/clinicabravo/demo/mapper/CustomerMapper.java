package com.clinicabravo.demo.mapper;

import com.clinicabravo.demo.dto.CustomerDto;
import com.clinicabravo.demo.entity.Customer;

public class CustomerMapper {
    public static CustomerDto mapToCustomerDto(Customer customer){
        return new CustomerDto(
                customer.getId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getPhone()
        );
    }

    public static Customer mapToCustomer(CustomerDto customerDto){
        return new Customer(
                customerDto.getId(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmail(),
                customerDto.getPhone()
        );
    }
}


