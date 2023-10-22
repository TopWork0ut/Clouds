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
@Relation(itemRelation = "schedule", collectionRelation = "schedules")
public class ScheduleDto extends RepresentationModel<ScheduleDto>  {
    private final Integer id;
    private final LocalDate startDieting;
    private final LocalDate endDieting;
    private final String description;
}
