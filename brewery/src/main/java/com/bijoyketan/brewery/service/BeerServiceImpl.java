package com.bijoyketan.brewery.service;

import com.bijoyketan.brewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
//TODO - implementation of the delete beer method.
public class BeerServiceImpl implements BeerService {
    @Override
    public BeerDto getBeerbyID(UUID beerID) {
        return null;
    }

    @Override
    public BeerDto createBeer(BeerDto beerDto) {
        return null;
    }

    @Override
    public BeerDto updateBeer(UUID newBeerId, BeerDto newBeerDto) {
        return null;
    }

    @Override
    public BeerDto deleteBeer(UUID beerID) {
        return null;
    }
}
