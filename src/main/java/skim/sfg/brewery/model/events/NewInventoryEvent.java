package skim.sfg.brewery.model.events;

import lombok.NoArgsConstructor;
import skim.sfg.brewery.model.BeerDto;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
