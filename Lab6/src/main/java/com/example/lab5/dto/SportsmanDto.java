package com.example.lab5.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Builder
@Getter
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Relation(itemRelation = "sportsman", collectionRelation = "sportsmen")
public class SportsmanDto extends RepresentationModel<SportsmanDto> {
    private final Integer id;
    private final String name;
    private final String surname;
    private final String kindOfSport;
    private final Integer height;
    private final Integer weight;
    private final Integer scheduleID;
    private final Integer doctor_id;
}
