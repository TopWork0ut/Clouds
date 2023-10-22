package com.example.lab5.dto.assembler;

import com.example.lab5.controller.SupplementController;
import com.example.lab5.domain.Supplement;
import com.example.lab5.dto.SupplementDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class SupplementDtoAssembler  implements RepresentationModelAssembler<Supplement, SupplementDto> {
    @Override
    public SupplementDto toModel(Supplement entity) {
        SupplementDto supplementDto = SupplementDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .components(entity.getComponents())
                .calories(entity.getCalories())
                .manufacturer(entity.getManufacturer())
                .productionDate(entity.getProductionDate().toLocalDate())
                .consumptionDate(entity.getConsumptionDate().toLocalDate())
                .build();
        Link selfLink = linkTo(methodOn(SupplementController.class).getSupplement(supplementDto.getId())).withSelfRel();
        supplementDto.add(selfLink);
        return supplementDto;
    }

    @Override
    public CollectionModel<SupplementDto> toCollectionModel(Iterable<? extends Supplement> entities) {
        CollectionModel<SupplementDto> supplementDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(SupplementController.class).getAllSupplements()).withSelfRel();
        supplementDtos.add(selfLink);
        return supplementDtos;
    }

    public CollectionModel<SupplementDto> toCollectionModel(Iterable<? extends Supplement> entities, Link link) {
        CollectionModel<SupplementDto> supplementDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        supplementDtos.add(link);
        return supplementDtos;
    }
}
