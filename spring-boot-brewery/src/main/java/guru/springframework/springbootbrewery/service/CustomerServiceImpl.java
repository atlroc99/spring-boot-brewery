package guru.springframework.springbootbrewery.service;

import guru.springframework.springbootbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerID) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Jon")
                .build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customerDto) {
        CustomerDto savedCustomer = CustomerDto.builder()
                .id(customerDto.getId())
                .name(customerDto.getName())
                .build();

        return customerDto;
    }

    @Override
    public void updateCustomer(UUID customerID, CustomerDto customerDto) {
        CustomerDto existingCustomer = CustomerDto.builder()
                .id(customerID)
                .build();

        existingCustomer.setName(customerDto.getName());
        log.debug("Customer: [name: " + existingCustomer.getName()
                + " ID: " + existingCustomer.getId()
                + "] has been updated!!");
    }

    @Override
    public void deleteCustomer(UUID customerID) {
        log.debug("Customer with ID : [" + customerID + "] has been deleted!!");
    }
}
