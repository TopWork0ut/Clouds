package com.example.lab5.dto.assembler;

import com.example.lab5.controller.DishController;
import com.example.lab5.domain.Dish;
import com.example.lab5.dto.DishDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class DishDtoAssembler implements RepresentationModelAssembler<Dish, DishDto> {
    @Override
    public DishDto toModel(Dish entity) {
        DishDto dishDto = DishDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .components(entity.getComponents())
                .calories(entity.getCalories())
                .manufacturer(entity.getManufacturer())
                .productionDate(entity.getProductionDate().toLocalDate())
                .consumptionDate(entity.getConsumptionDate().toLocalDate())
                .build();
        Link selfLink = linkTo(methodOn(DishController.class).getDish(dishDto.getId())).withSelfRel();
        dishDto.add(selfLink);
        return dishDto;
    }

    @Override
    public CollectionModel<DishDto> toCollectionModel(Iterable<? extends Dish> entities) {
        CollectionModel<DishDto> dishDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(DishController.class).getAllDishes()).withSelfRel();
        dishDtos.add(selfLink);
        return dishDtos;
    }

    public CollectionModel<DishDto> toCollectionModel(Iterable<? extends Dish> entities, Link link) {
        CollectionModel<DishDto> dishDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        dishDtos.add(link);
        return dishDtos;
    }
}
