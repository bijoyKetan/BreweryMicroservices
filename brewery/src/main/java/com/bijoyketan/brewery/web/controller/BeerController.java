package com.bijoyketan.brewery.web.controller;

import com.bijoyketan.brewery.service.BeerService;
import com.bijoyketan.brewery.service.CustomerService;
import com.bijoyketan.brewery.web.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
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
@Slf4j
public class BeerController {

    private final BeerService beerService;

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    //GET - Retrieve a resource by some ID or by using a set of query parameters.
    @GetMapping(value = "/{beerID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getBeerByID(@PathVariable String beerID) {
        try {
            return new ResponseEntity<>(beerService.getBeerbyID(UUID.fromString(beerID)), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //For POST - provide the resource that needs to be created.
    // Resource provided in JSON format
    @PostMapping
    public ResponseEntity<Object> createBeer(@RequestBody BeerDto beerDto) {
        try {
            beerService.createBeer(beerDto);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Post Header", "api/v1/beer  \n" + beerDto);
            log.info("Created beer is: " + beerDto);
            return new ResponseEntity<>(beerDto, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //PUT - Modify a resource, so pass the resource and also an ID of the existing resource
    //Also provide the new state of the resource
    @PutMapping("/{beerID}")
    public ResponseEntity<Object> updateBeerDto(@PathVariable UUID beerID, @RequestBody BeerDto beerDto) {
        try {
            return new ResponseEntity<>(beerService.updateBeer(beerID, beerDto), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //DELETE - Given a beerID, delete it.
    @DeleteMapping("/{beerID}")
    public ResponseEntity<Object> deleteBeer(@PathVariable UUID beerID) {
        try {
            beerService.deleteBeer(beerID);
            log.info("BeerDto deleted, UUID: " + beerID.toString());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
