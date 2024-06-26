package com.clinicabravo.demo.service.implementation;

import com.clinicabravo.demo.dto.CustomerDto;
import com.clinicabravo.demo.entity.Customer;
import com.clinicabravo.demo.exception.ResourceNotFoundException;
import com.clinicabravo.demo.mapper.CustomerMapper;
import com.clinicabravo.demo.repository.CustomerRepository;
import com.clinicabravo.demo.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public CustomerDto getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() ->
                new ResourceNotFoundException(String.format("Customer is not exist with given id: %s ", customerId)));
        return CustomerMapper.mapToCustomerDto(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        List<Customer> customers =  customerRepository.findAll();
        return customers.stream().map(CustomerMapper::mapToCustomerDto)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDto updateCustomer(Long customerId, CustomerDto updatedCustomer) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(String.format("Customer is not exist with given id: %s ", customerId)));

        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setLastName(updatedCustomer.getLastName());
        customer.setPhone(updatedCustomer.getPhone());
        customer.setEmail(updatedCustomer.getEmail());

       Customer  updatedCustomerObj = customerRepository.save(customer);

        return  CustomerMapper.mapToCustomerDto(updatedCustomerObj);
    }

    @Override
    public void deleteCustomer(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() ->
                        new ResourceNotFoundException(String.format("Customer is not exist with given id: %s ", customerId)));
        customerRepository.deleteById(customerId);
    }
}
