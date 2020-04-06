package com.bijoyketan.brewery.web.controller;

import com.bijoyketan.brewery.service.BeerService;
import com.bijoyketan.brewery.web.model.BeerDto;
import com.bijoyketan.brewery.web.model.BeerStyleEnum;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    Gson gson;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BeerService beerService;

    @Test
    void getBeerByID() throws Exception {
        mockMvc.perform(get("/api/v1/beer/" + UUID.randomUUID().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void createBeer() throws Exception {
        BeerDto beerDto = BeerDto.builder().beerStyle(BeerStyleEnum.LAGER).build();
        String beerDtoString = gson.toJson(beerDto);

        mockMvc.perform(post("/api/v1/beer")
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoString))
                .andExpect(status().isCreated());
    }

    @Test
    void updateBeerDto() throws Exception {
        BeerDto beerDto = BeerDto.builder().build();
        String beerDtoStr = gson.toJson(beerDto);
        String path = UUID.randomUUID().toString();

        mockMvc.perform(put("/api/v1/beer/" + path)
                .contentType(MediaType.APPLICATION_JSON)
                .content(beerDtoStr))
                .andExpect(status().isAccepted());

    }

    @Test
    void deleteBeer() throws Exception {
        String pathVariable = UUID.randomUUID().toString();

        mockMvc.perform(delete("/api/v1/beer/"+ pathVariable)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}