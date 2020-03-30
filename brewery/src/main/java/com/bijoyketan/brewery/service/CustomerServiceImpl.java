package com.bijoyketan.brewery.service;

import com.bijoyketan.brewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerByID(UUID customerID) {
        return CustomerDTO
                .builder()
                .customerID(customerID)
                .name("Thomas Muller")
                .build();
    }

    @Override
    public CustomerDTO createCustomerDto(CustomerDTO customerDTO) {
        return CustomerDTO.builder()
                .name(customerDTO.getName())
                .customerID(UUID.randomUUID())
                .build();
    }

    @Override
    public CustomerDTO updateCustomerDto(UUID newCustomerID, CustomerDTO newCustomerDto) {
        CustomerDTO oldCustomerDto = getCustomerByID(newCustomerID);
        oldCustomerDto.setCustomerID(newCustomerID);
        oldCustomerDto.setName(newCustomerDto.getName());
        return oldCustomerDto;
    }

    @Override
    public void deleteCustomer(UUID customerID) {
        //to be implemented later
        log.info("Customer deletion code running...");
    }
}
