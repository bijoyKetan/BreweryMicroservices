package com.bijoyketan.brewery.service;

import com.bijoyketan.brewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerByID(UUID customerID);

    CustomerDTO createCustomerDto(CustomerDTO customerDTO);

    CustomerDTO updateCustomerDto(UUID newCustomerID, CustomerDTO newCustomerDto);

    void deleteCustomer(UUID customerID);
}
