package guru.springframework.springbootbrewery.web.service;

import guru.springframework.springbootbrewery.web.model.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public CustomerDto getCustomerById(UUID customerID) {
        return CustomerDto.builder()
                .id(UUID.randomUUID())
                .name("Jon")
                .build();
    }
}
