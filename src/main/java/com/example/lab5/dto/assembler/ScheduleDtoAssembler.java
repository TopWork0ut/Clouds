package com.example.lab5.dto.assembler;

import com.example.lab5.controller.ScheduleController;
import com.example.lab5.domain.Schedule;
import com.example.lab5.dto.ScheduleDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class ScheduleDtoAssembler implements RepresentationModelAssembler<Schedule, ScheduleDto> {
    @Override
    public ScheduleDto toModel(Schedule entity) {
        ScheduleDto scheduleDto = ScheduleDto.builder()
                .id(entity.getId())
                .startDieting(entity.getStartDieting().toLocalDate())
                .endDieting(entity.getEndDieting().toLocalDate())
                .description(entity.getDescription())
                .build();
        Link selfLink = linkTo(methodOn(ScheduleController.class).getSchedule(scheduleDto.getId())).withSelfRel();
        scheduleDto.add(selfLink);
        return scheduleDto;
    }

    @Override
    public CollectionModel<ScheduleDto> toCollectionModel(Iterable<? extends Schedule> entities) {
        CollectionModel<ScheduleDto> scheduleDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        Link selfLink = linkTo(methodOn(ScheduleController.class).getAllSchedules()).withSelfRel();
        scheduleDtos.add(selfLink);
        return scheduleDtos;
    }

    public CollectionModel<ScheduleDto> toCollectionModel(Iterable<? extends Schedule> entities, Link link) {
        CollectionModel<ScheduleDto> scheduleDtos = RepresentationModelAssembler.super.toCollectionModel(entities);
        scheduleDtos.add(link);
        return scheduleDtos;
    }
}
