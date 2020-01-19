package guru.springframework.springbootbrewery.bootstrap;

import guru.springframework.springbootbrewery.domain.Beer;
import guru.springframework.springbootbrewery.repository.BeerRepository;
import guru.springframework.springbootbrewery.web.model.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeer();
    }

    private void loadBeer() {
        if (beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle(BeerStyleEnum.PALE_ALE.toString())
                    .upc(12345L)
                    .qtyToBrew(200)
                    .minQtyOnHand(12)
                    .price(new BigDecimal("12.99"))
                    .build());

            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle(BeerStyleEnum.LAGER.toString())
                    .upc(300039L)
                    .qtyToBrew(300)
                    .minQtyOnHand(22)
                    .price(new BigDecimal("10.99"))
                    .build());
        }

        System.out.println("Loaded beers: " + beerRepository.count());
    }
}