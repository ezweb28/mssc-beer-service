package skim.springframework.msscbeerservice.events;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import skim.springframework.msscbeerservice.web.model.BeerDto;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
@Builder
public class BeerEvent implements Serializable {

    static final long serialVersionUID = 5968964133369114443L;

    private final BeerDto beerDto;
}
