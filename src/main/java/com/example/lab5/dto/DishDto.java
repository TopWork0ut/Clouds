package com.example.lab5.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

import java.time.LocalDate;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "dish", collectionRelation = "dishes")
public class DishDto extends RepresentationModel<DishDto> {
    private final Integer id;
    private final String name;
    private final String components;
    private final Integer calories;
    private final String manufacturer;
    private final LocalDate productionDate;
    private final LocalDate consumptionDate;
}
