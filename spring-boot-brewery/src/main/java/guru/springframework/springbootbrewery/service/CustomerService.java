package guru.springframework.springbootbrewery.service;

import guru.springframework.springbootbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerID);
    CustomerDto saveCustomer(CustomerDto customerDto);
    void updateCustomer(UUID customerID, CustomerDto customerDto);
    void deleteCustomer(UUID customerID);
}
