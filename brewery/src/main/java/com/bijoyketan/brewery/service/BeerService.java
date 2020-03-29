package com.bijoyketan.brewery.service;

import com.bijoyketan.brewery.web.model.BeerDto;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerbyID(UUID beerID);

    BeerDto createBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID newBeerID, BeerDto newBeerDto);
}
