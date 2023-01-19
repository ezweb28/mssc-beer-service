package skim.springframework.msscbeerservice.web.mappers;

import org.mapstruct.Mapper;
import skim.springframework.msscbeerservice.domain.Beer;
import skim.springframework.msscbeerservice.web.model.BeerDto;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {

    BeerDto beerToBeerDto(Beer beer);

    Beer beerDtoToBeer(BeerDto dto);
}
