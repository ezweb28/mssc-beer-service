package skim.springframework.msscbeerservice.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import skim.springframework.msscbeerservice.domain.Beer;
import skim.sfg.brewery.model.BeerStyleEnum;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest);

    Page<Beer> findAllByBeerName(String beerName, PageRequest pageRequest);

    Page<Beer> findAllByBeerStyle(String beerName, PageRequest pageRequest);

    Beer findByUpc(String upc);
}
