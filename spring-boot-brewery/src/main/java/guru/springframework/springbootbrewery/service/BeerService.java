package guru.springframework.springbootbrewery.service;

import guru.springframework.springbootbrewery.web.model.BeerDto;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
    List<BeerDto> getBearList() ;
    BeerDto getBeerByRandomID(UUID beerId);
    BeerDto saveNewBeer(BeerDto beerDto);
    void deleteBeer(UUID beerId);
    BeerDto updateBeer(UUID beerId, BeerDto beerDto);
}
