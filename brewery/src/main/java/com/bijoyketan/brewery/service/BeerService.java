package com.bijoyketan.brewery.service;

import com.bijoyketan.brewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface BeerService {
    BeerDto getBeerbyID(UUID beerID);
}
