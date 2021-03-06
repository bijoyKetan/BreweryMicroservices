package com.bijoyketan.brewery.web.controller;

import com.bijoyketan.brewery.service.CustomerService;
import com.bijoyketan.brewery.web.model.BeerDto;
import com.bijoyketan.brewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.channels.ScatteringByteChannel;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/customer")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //Get customer by customerID in pathvariable
    @GetMapping(value = "/{customerID}")
    public ResponseEntity<Object> getCustomerByID(@PathVariable UUID customerID) {
        try {
            return new ResponseEntity<>(customerService.getCustomerByID(customerID), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //POST - Create customer
    @PostMapping
    public ResponseEntity<Object> createCustomer(@RequestBody CustomerDTO customerDTO) {
        try {
            log.info("Created customer is: " + customerDTO.toString());
            return new ResponseEntity<>(customerService.createCustomerDto(customerDTO), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //PUT - Modify existing customer
    @PutMapping("/{newCustomerID}")
    public ResponseEntity<Object> updateCustomer(@PathVariable UUID newCustomerID, @RequestBody CustomerDTO newCustomerDto) {
        try {
            log.info("Customer updated: " + newCustomerDto.toString());
            return new ResponseEntity<>(customerService.updateCustomerDto(newCustomerID, newCustomerDto), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETE - delete existing customer
    @DeleteMapping(value = "/{customerID}")
    //TODO - complete this
    public ResponseEntity<Object> deleteCustomer(@PathVariable UUID customerID) {
        try {
            customerService.deleteCustomer(customerID);
            log.info("CustomerDto deleted: " + customerID.toString());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Exception in deleteCustomer method...");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
