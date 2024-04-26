package com.clinicabravo.demo.service;

import com.clinicabravo.demo.dto.CustomerDto;

public interface CustomerService {
    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(Long customerId);
}
