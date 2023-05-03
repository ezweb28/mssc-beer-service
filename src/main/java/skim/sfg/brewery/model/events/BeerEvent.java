package skim.sfg.brewery.model.events;

import lombok.*;
import skim.sfg.brewery.model.BeerDto;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BeerEvent implements Serializable {

    static final long serialVersionUID = 5968964133369114443L;

    private BeerDto beerDto;
}