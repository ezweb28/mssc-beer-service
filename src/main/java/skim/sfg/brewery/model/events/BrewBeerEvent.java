package skim.sfg.brewery.model.events;

import lombok.NoArgsConstructor;
import skim.sfg.brewery.model.BeerDto;

@NoArgsConstructor
public class BrewBeerEvent extends BeerEvent {

    public BrewBeerEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
