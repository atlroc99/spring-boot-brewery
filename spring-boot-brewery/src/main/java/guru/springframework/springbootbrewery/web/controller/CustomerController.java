package guru.springframework.springbootbrewery.web.controller;

import guru.springframework.springbootbrewery.ServerConfigs.Server;
import guru.springframework.springbootbrewery.web.model.CustomerDto;
import guru.springframework.springbootbrewery.service.CustomerService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private CustomerService customerService;
    private Server server;

    public CustomerController(CustomerService customerService, Server server) {
        this.customerService = customerService;
        this.server = server;
    }

    @GetMapping({"/{customerID}"})
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable("customerID") UUID customerID) {
        return new ResponseEntity<>(customerService.getCustomerById(customerID), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<HttpHeaders> saveCustomer(@Valid @RequestBody CustomerDto customerDto) {
        CustomerDto newCusomter = customerService.saveCustomer(customerDto);
        String location = server.getHostingServer() + "api/v1/customer" + newCusomter.getId();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", location);

        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{customerID}")
    public ResponseEntity updateCustomer(@PathVariable("customerID") UUID customerID, @Valid @RequestBody CustomerDto customerDto) {
        customerService.updateCustomer(customerID, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{customerID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerID") UUID customerID) {
        customerService.deleteCustomer(customerID);
    }
}
