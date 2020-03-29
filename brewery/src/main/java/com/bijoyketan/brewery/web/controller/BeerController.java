package com.bijoyketan.brewery.web.controller;

import com.bijoyketan.brewery.service.BeerService;
import com.bijoyketan.brewery.service.CustomerService;
import com.bijoyketan.brewery.web.model.BeerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/beer")
public class BeerController {

    private final BeerService beerService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    //GET - Retrieve a resource by some ID or by using a set of query parameters.
    @GetMapping(value = "/{beerID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getBeerByID(HttpServletRequest request, @PathVariable String beerID) {
        try {
            return new ResponseEntity<>(beerService.getBeerbyID(UUID.fromString(beerID)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //For POST - provide the resource that needs to be created.
    @PostMapping
    public ResponseEntity<Object> createBeer(BeerDto beerDto) {
        try {
            //TODO - Create beerDto properly using JSON representation of the object
            BeerDto saveBeer = beerService.createBeer(beerDto);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Post Header", "api/v1/beer  \n" + saveBeer.toString());
            return new ResponseEntity<>(headers, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //PUT - Modify a resource, so pass the resource and also an ID of the existing resource
    //Also provide the new state of the resource
    @PutMapping("/{beerID}")
    public ResponseEntity<Object> updateBeerDto(@PathVariable UUID beerID, @RequestBody BeerDto beerDto) {
        try{
            return new ResponseEntity<>(beerService.updateBeer(beerID, beerDto), HttpStatus.ACCEPTED);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
