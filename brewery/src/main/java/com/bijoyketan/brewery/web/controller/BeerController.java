package com.bijoyketan.brewery.web.controller;

import com.bijoyketan.brewery.service.BeerService;
import com.bijoyketan.brewery.web.model.BeerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/beer")
public class BeerController {

    private final BeerService beerService;
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    //Get beer by pathvariable
    @GetMapping(value = "/{beerID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getBeerByID(HttpServletRequest request,  @PathVariable String beerID) {
        try{
            return new ResponseEntity<>(beerService.getBeerbyID(UUID.fromString(beerID)), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            log.debug(request.getParameter("json"));
            return new ResponseEntity<>("Error in getBeerByID request. Check the payload", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
