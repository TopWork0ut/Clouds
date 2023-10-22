package com.example.lab5.dto.assembler;

import com.example.lab5.controller.SportsmanController;
import com.example.lab5.domain.Sportsman;
import com.example.lab5.dto.SportsmanDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SportsmanDtoAssembler implements RepresentationModelAssembler<Sportsman, SportsmanDto> {
    @Override
    public SportsmanDto toModel(Sportsman entity) {
        SportsmanDto sportsmanDto = SportsmanDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .surname(entity.getSurname())
                .kindOfSport(entity.getKindOfSport())
                .height(entity.getHeight())
                .weight(entity.getWeight())
                .scheduleID(entity.getSchedule().getId())
                .doctor_id(entity.getDoctor_id())
                .build();
        Link selfLink = linkTo(methodOn(SportsmanController.class).getSportsman(sportsmanDto.getId())).withSelfRel();
        sportsmanDto.add(selfLink);
        return sportsmanDto;
    }

    @Override
    public CollectionModel<SportsmanDto> toCollectionModel(Iterable<? extends Sportsman> entities) {
        CollectionModel<SportsmanDto> sportsmanDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(SportsmanController.class).getAllSportsmen()).withSelfRel();
        sportsmanDtos.add(selfLink);
        return sportsmanDtos;
    }

    public CollectionModel<SportsmanDto> toCollectionModel(Iterable<? extends Sportsman> entities, Link link) {
        CollectionModel<SportsmanDto> sportsmanDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        sportsmanDtos.add(link);
        return sportsmanDtos;
    }
}
