package skim.springframework.msscbeerservice.bootstrap;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import skim.springframework.msscbeerservice.domain.Beer;
import skim.springframework.msscbeerservice.repositories.BeerRepository;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@Component
public class BeerLoader implements CommandLineRunner {

    public static final String BEER_1_UPC = "0631234200036";
    public static final String BEER_2_UPC = "0631234300019";
    public static final String BEER_3_UPC = "0083783375213";

    private final BeerRepository beerRepository;

    @Override
    public void run(String... args) throws Exception {
        if(beerRepository.count() == 0) {
            loadBeerObjects();
        }
    }

    private void loadBeerObjects() {
        Beer b1 = Beer.builder()
                .beerName("Mango Bobs")
                .beerStyle("IPA")
                .quantityToBrew(200)
                .minOnHand(12)
                .upc(BEER_1_UPC)
                .price(new BigDecimal("12.95"))
                .build();

        Beer b2 = Beer.builder()
                .beerName("Galaxy Cat")
                .beerStyle("PALE_ALE")
                .quantityToBrew(200)
                .minOnHand(12)
                .upc(BEER_2_UPC)
                .price(new BigDecimal("11.95"))
                .build();

        Beer b3 = Beer.builder()
                .beerName("No Hammers On The Bar")
                .beerStyle("PALE_ALE")
                .quantityToBrew(200)
                .minOnHand(12)
                .upc(BEER_3_UPC)
                .price(new BigDecimal("11.95"))
                .build();

        beerRepository.save(b1);
        beerRepository.save(b2);
        beerRepository.save(b3);
    }
}
