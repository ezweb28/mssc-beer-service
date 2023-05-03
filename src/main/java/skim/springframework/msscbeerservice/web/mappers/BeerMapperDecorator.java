package skim.springframework.msscbeerservice.web.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import skim.springframework.msscbeerservice.domain.Beer;
import skim.springframework.msscbeerservice.services.inventory.BeerInventoryService;
import skim.sfg.brewery.model.BeerDto;

public abstract class BeerMapperDecorator implements BeerMapper {

//    @Autowired
    private BeerInventoryService beerInventoryService;

//    @Qualifier("delegate")
//    @Autowired
    private BeerMapper mapper;

    @Autowired
    public void setBeerInventoryService(BeerInventoryService beerInventoryService) {
        this.beerInventoryService = beerInventoryService;
    }

    @Autowired
    @Qualifier("delegate")
    public void setMapper(BeerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public BeerDto beerToBeerDto(Beer beer) {
        return mapper.beerToBeerDto(beer);
    }

    @Override
    public BeerDto beerToBeerDtoWithInventory(Beer beer) {
        BeerDto dto = mapper.beerToBeerDto(beer);
        dto.setQuantityOnHand(beerInventoryService.getOnhandInventory(beer.getId()));
        return dto;
    }

    @Override
    public Beer beerDtoToBeer(BeerDto beerDto) {
        return mapper.beerDtoToBeer(beerDto);
    }

}
