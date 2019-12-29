package guru.springframework.springbootbrewery.web.service;

import guru.springframework.springbootbrewery.web.model.BeerDto;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    BeerDto getBeerById(UUID beerId);
    List<BeerDto> getBearList() ;
}
