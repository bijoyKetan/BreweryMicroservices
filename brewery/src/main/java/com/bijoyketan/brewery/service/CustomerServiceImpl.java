package com.bijoyketan.brewery.service;

import com.bijoyketan.brewery.web.model.CustomerDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerByID(UUID customerID) {
        return CustomerDTO
                .builder()
                .customerID(customerID)
                .name("Thomas Muller")
                .build();
    }
}
