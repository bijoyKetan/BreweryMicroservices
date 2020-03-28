package com.bijoyketan.brewery.service;

import com.bijoyketan.brewery.web.model.BeerDto;

import java.util.UUID;

public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerbyID(UUID beerID) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .name("Miller Lite")
                .style("Galaxy")
                .build();
    }
}
