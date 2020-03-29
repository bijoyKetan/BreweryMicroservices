package com.bijoyketan.brewery.service;

import com.bijoyketan.brewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerbyID(UUID beerID) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .name("Miller Lite")
                .style("Galaxy")
                .build();
    }

    @Override
    public BeerDto createBeer(BeerDto beerDto) {
        return BeerDto.builder()
                .id(UUID.randomUUID())
                .name("Corona")
                .style("Lime")
                .build();
    }


}
