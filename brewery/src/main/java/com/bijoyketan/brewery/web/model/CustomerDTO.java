package com.bijoyketan.brewery.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerDTO {
    private String name;
    private UUID customerID;

    public static CustomerDTOBuilder builder() {
        return new CustomerDTOBuilder();
    }
}
