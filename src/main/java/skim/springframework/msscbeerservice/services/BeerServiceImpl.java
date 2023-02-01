package skim.springframework.msscbeerservice.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import skim.springframework.msscbeerservice.domain.Beer;
import skim.springframework.msscbeerservice.repositories.BeerRepository;
import skim.springframework.msscbeerservice.web.controller.NotFoundException;
import skim.springframework.msscbeerservice.web.mappers.BeerMapper;
import skim.springframework.msscbeerservice.web.model.BeerDto;
import skim.springframework.msscbeerservice.web.model.BeerPagedList;
import skim.springframework.msscbeerservice.web.model.BeerStyleEnum;

import java.util.UUID;
import java.util.stream.Collectors;

//@RequiredArgsConstructor
@Service
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;

    public BeerServiceImpl(BeerRepository beerRepository, BeerMapper beerMapper) {
        this.beerRepository = beerRepository;
        this.beerMapper = beerMapper;
    }


    @Override
    public BeerDto getById(UUID beerId) {
        return beerMapper.beerToBeerDto(
                beerRepository.findById(beerId).orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {
        Beer beer = beerMapper.beerDtoToBeer(beerDto);
        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }

    @Override
    public BeerDto updateBeer(UUID beerId, BeerDto beerDto) {
        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);

        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());

        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }

    @Override
    public BeerPagedList listBeers(String beerName, BeerStyleEnum beerStyle, PageRequest pageRequest) {

        BeerPagedList beerPagedList;
        Page<Beer> beerPage;
        boolean hasBeerName = StringUtils.hasText(beerName);
        boolean hasBeerStyle = beerStyle != null && StringUtils.hasText(beerStyle.name());

        if (hasBeerName && hasBeerStyle) {
            //search both
            beerPage = beerRepository.findAllByBeerNameAndBeerStyle(beerName, beerStyle, pageRequest);
        } else if (hasBeerName) {
            beerPage = beerRepository.findAllByBeerName(beerName, pageRequest);
        } else if (hasBeerStyle) {
            beerPage = beerRepository.findAllByBeerStyle(beerStyle.name(), pageRequest);
        } else {
            beerPage = beerRepository.findAll(pageRequest);
        }

        beerPagedList = new BeerPagedList(beerPage
                .getContent()
                .stream()
                .map(beerMapper::beerToBeerDto)
                .collect(Collectors.toList()),
                PageRequest
                        .of(beerPage.getPageable().getPageNumber(),
                                beerPage.getPageable().getPageSize()),
                beerPage.getTotalElements());

        return beerPagedList;
    }
}
