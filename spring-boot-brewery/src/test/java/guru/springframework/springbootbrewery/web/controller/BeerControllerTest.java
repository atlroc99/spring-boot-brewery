package guru.springframework.springbootbrewery.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import java.util.UUID;
@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    private final String baseApi = "/api/v1/beer";

    @Test
    void getBeers(){}


    @Test
    void getBeer() throws Exception {
        String getBeerURL = baseApi + "/" + UUID.randomUUID().toString();
        mockMvc.perform(get(getBeerURL).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    void saveNewBeer() {
    }

    @Test
    void updateBeerById() {}

    @Test
    void deleteBeerById() {
    }
}