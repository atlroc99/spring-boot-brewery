package guru.springframework.springbootbrewery.web.service;

import guru.springframework.springbootbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {
    CustomerDto getCustomerById(UUID customerID);
}
