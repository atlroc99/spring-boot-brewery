package guru.springframework.springbootbrewery.web.service;

import guru.springframework.springbootbrewery.web.model.BeerDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class BeerServiceImpl implements BeerService {

    private List<BeerDto> bearList = new ArrayList<>();

    public BeerServiceImpl() {
        System.out.println("calling CreateBearlist");
        createBeerList();
    }

    @Override
    public BeerDto getBeerById(UUID beerId) {
        System.out.println("Get beear by ID : " + beerId);
        if (beerId == null) return BeerDto.builder().build();

        String long_upc = beerId.toString();
        BeerDto beerDto = null;

        System.out.println("size of bearList: " + bearList.size());
        if (!this.bearList.isEmpty()) {
            for (BeerDto bd : this.bearList) {
                if (bd.getId().equals(beerId)) {
                    beerDto = new BeerDto();
                    beerDto.setId(bd.getId());
                    beerDto.setBeerName(bd.getBeerName());
                    beerDto.setBeerStyle(bd.getBeerStyle());
                    beerDto.setUpc(bd.getUpc());
                    break;
                }
            }
        }
        return beerDto;

        

     /*   return BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Galaxy cat")
                .beerStyle("Pale Ale")
                .upc(long_upc)
                .build();*/
    }

    @Override
    public List<BeerDto> getBearList() {
        return this.bearList;
    }

    private void createBeerList() {
        System.out.println("creating beer list");

        BeerDto bear_1 = BeerDto.builder()
                .beerStyle("Black bear")
                .beerName("Bear 1")
                .id(UUID.randomUUID())
                .build();

        BeerDto bear_2 = BeerDto.builder()
                .beerStyle("Blue bear")
                .beerName("Bear 2")
                .id(UUID.randomUUID())
                .build();

        BeerDto bear_3 = BeerDto.builder()
                .beerStyle("Red Bear")
                .beerName("Bear 3")
                .id(UUID.randomUUID())
                .build();

        BeerDto bear_4 = BeerDto.builder()
                .beerStyle("Black bear")
                .beerName("Bear 4")
                .id(UUID.randomUUID())
                .build();

        BeerDto bear_5 = BeerDto.builder()
                .beerStyle("White Bear")
                .beerName("Bear 5")
                .id(UUID.randomUUID())
                .build();

        BeerDto bear_6 = BeerDto.builder()
                .beerStyle("Yello Bear")
                .beerName("Bear 6")
                .id(UUID.randomUUID())
                .build();
        BeerDto bear_7 = BeerDto.builder()
                .beerStyle("Orange Bear")
                .beerName("Bear 7")
                .id(UUID.randomUUID())
                .build();

        BeerDto bear_8 = BeerDto.builder()
                .beerStyle("Green bear")
                .beerName("Bear 8")
                .id(UUID.randomUUID())
                .build();

        BeerDto bear_9 = BeerDto.builder()
                .beerStyle("Pink Bear")
                .beerName("Bear 9")
                .id(UUID.randomUUID())
                .build();


        BeerDto bear_10 = BeerDto.builder()
                .beerStyle("Purple Bear")
                .beerName("Bear 10")
                .id(UUID.randomUUID())
                .build();

        bearList.add(bear_1);
        bearList.add(bear_2);
        bearList.add(bear_3);
        bearList.add(bear_4);
        bearList.add(bear_5);
        bearList.add(bear_6);
        bearList.add(bear_7);
        bearList.add(bear_8);
        bearList.add(bear_9);
        bearList.add(bear_10);
    }
}
