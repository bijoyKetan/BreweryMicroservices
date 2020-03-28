package com.bijoyketan.brewery.web.controller;

import com.bijoyketan.brewery.service.BeerService;
import com.bijoyketan.brewery.web.model.BeerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/beer")
public class BeerController {

    private final BeerService beerService;

    @Autowired
    public BeerController (BeerService beerService){
        this.beerService = beerService;
    }

    //Get beer by pathvariable
    //TODO - Complete this.
    @GetMapping
    public ResponseEntity<BeerDto> getBeerByID(){
        return null;
    }

}
