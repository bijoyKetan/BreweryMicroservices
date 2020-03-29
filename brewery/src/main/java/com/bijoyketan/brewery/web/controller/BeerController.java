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

    //Get beer by pathvariable
    @GetMapping(value = "/{beerID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getBeerByID(HttpServletRequest request, @PathVariable String beerID) {
        try {
            return new ResponseEntity<>(beerService.getBeerbyID(UUID.fromString(beerID)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Task - create a beer resource using a random UUID
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
}
