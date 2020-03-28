package com.bijoyketan.brewery.service;

import com.bijoyketan.brewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    CustomerDTO getCustomerByID(UUID customerID);
}