package skim.springframework.msscbeerservice.services;

import org.springframework.data.domain.PageRequest;
import skim.sfg.brewery.model.BeerDto;
import skim.sfg.brewery.model.BeerPagedList;
import skim.sfg.brewery.model.BeerStyleEnum;

import java.util.UUID;

public interface BeerService {

    BeerDto getById(UUID beerId, Boolean showInventoryOnHand);

    BeerDto saveNewBeer(BeerDto beerDto);

    BeerDto updateBeer(UUID beerId, BeerDto beerDto);

    BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);

    BeerDto getByUpc(String upc);
}
