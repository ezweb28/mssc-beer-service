package skim.springframework.msscbeerservice.services;

import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import skim.springframework.msscbeerservice.web.model.BeerDto;
import skim.springframework.msscbeerservice.web.model.BeerPagedList;
import skim.springframework.msscbeerservice.web.model.BeerStyleEnum;

import java.util.UUID;

public interface BeerService {

    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDto getByUpc(String upc);
}
