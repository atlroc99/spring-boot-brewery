package guru.springframework.springbootbrewery.web.controller;

import guru.springframework.springbootbrewery.web.model.BeerDto;
import guru.springframework.springbootbrewery.web.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }
                             
    @GetMapping("")
    public ResponseEntity<List<BeerDto>> getBeers() {
        return new ResponseEntity<>(beerService.getBearList(), HttpStatus.OK);
    }

    @GetMapping({"/{beerId}"})
    public ResponseEntity getBeer(@PathVariable("beerId") UUID beerId) {
        //return new ResponseEntity<>(BeerDto.builder().build(), HttpStatus.OK);
        return new ResponseEntity<>(beerService.getBeerById(beerId), HttpStatus.OK);
    }

    @GetMapping({"random-beer/{beerId}"})
    public ResponseEntity<BeerDto> getBeerByRandomId(@PathVariable("beerId") UUID uuid) {
        return new ResponseEntity<>(beerService.getBeerByRandomID(uuid), HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<BeerDto> saveNewBeer() {
        //todo impl
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public  ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @RequestBody BeerDto beerDto) {
        //todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    public ResponseEntity deleteBeerById(@PathVariable("beerId") UUID beerId) {
        //todo impl
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
