package guru.springframework.springbootbrewery.web.controller;

import guru.springframework.springbootbrewery.ServerConfigs.Server;
import guru.springframework.springbootbrewery.service.BeerService;
import guru.springframework.springbootbrewery.web.model.BeerDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/beer")
public class BeerController {

    private BeerService beerService;
    private Server server;

    public BeerController(BeerService beerService, Server server) {
        this.beerService = beerService;
        this.server = server;
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
    public ResponseEntity<HttpHeaders> saveNewBeer(@Valid @RequestBody BeerDto beerDto) {
        BeerDto savedBeer = beerService.saveNewBeer(beerDto);
        HttpHeaders httpHeaders = new HttpHeaders();
        String location = server.getHostingServer() + "api/v1/beer/" + savedBeer.getId();
        httpHeaders.add("Location", location);
        return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{beerId}")
    public ResponseEntity updateBeerById(@PathVariable("beerId") UUID beerId, @Valid @RequestBody BeerDto beerDto) {
        BeerDto updatedBeer = beerService.updateBeer(beerId, beerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{beerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBeerById(@PathVariable("beerId") UUID beerId) {
        beerService.deleteBeer(beerId);
    }

 /*   @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List> handleValidationException(ConstraintViolationException constrains) {
        List<String> errors = new ArrayList<>(constrains.getConstraintViolations().size());
        constrains.getConstraintViolations().forEach(constrain -> {
            errors.add(constrain.getPropertyPath() + " : " + constrain.getMessage());
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }*/
}
                                                                    
