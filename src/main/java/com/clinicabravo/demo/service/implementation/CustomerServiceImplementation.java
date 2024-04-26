package com.clinicabravo.demo.service.implementation;

import com.clinicabravo.demo.dto.CustomerDto;
import com.clinicabravo.demo.entity.Customer;
import com.clinicabravo.demo.mapper.CustomerMapper;
import com.clinicabravo.demo.repository.CustomerRepository;
import com.clinicabravo.demo.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerServiceImplementation implements CustomerService {
    private CustomerRepository customerRepository;
    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Customer customerSaved = customerRepository.save(customer);
        return CustomerMapper.mapToCustomerDto(customerSaved);
    }
}
