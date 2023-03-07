package skim.springframework.msscbeerservice.events;

import lombok.NoArgsConstructor;
import skim.springframework.msscbeerservice.web.model.BeerDto;

@NoArgsConstructor
public class NewInventoryEvent extends BeerEvent {

    public NewInventoryEvent(BeerDto beerDto) {
        super(beerDto);
    }
}
