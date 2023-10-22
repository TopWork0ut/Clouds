package com.example.lab5.controller;

import com.example.lab5.domain.Schedule;
import com.example.lab5.domain.Sportsman;
import com.example.lab5.dto.ScheduleDto;
import com.example.lab5.dto.assembler.ScheduleDtoAssembler;
import com.example.lab5.service.ScheduleService;
import com.example.lab5.service.SportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/schedules")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private SportsmanService sportsmanService;
    @Autowired
    private ScheduleDtoAssembler scheduleDtoAssembler;

    @GetMapping(value = "/{scheduleId}")
    public ResponseEntity<ScheduleDto> getSchedule(@PathVariable Integer scheduleId) {
        Schedule schedule = scheduleService.findById(scheduleId);
        ScheduleDto scheduleDto = scheduleDtoAssembler.toModel(schedule);
        return new ResponseEntity<>(scheduleDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<ScheduleDto>> getAllSchedules() {
        List<Schedule> schedules = scheduleService.findAll();
        CollectionModel<ScheduleDto> scheduleDtos = scheduleDtoAssembler.toCollectionModel(schedules);
        return new ResponseEntity<>(scheduleDtos, HttpStatus.OK);
    }

    @GetMapping(value = "findScheduleBySportsmanId/{sportsmanId}")
    public ResponseEntity<ScheduleDto> findScheduleBySportsmanId(@PathVariable Integer sportsmanId) {
        Sportsman sportsman = sportsmanService.findById(sportsmanId);
        ScheduleDto scheduleDto = scheduleDtoAssembler.toModel(sportsman.getSchedule());
        System.out.println("trial" + sportsman.getSchedule());
        return new ResponseEntity<>(scheduleDto, HttpStatus.OK);
    }

    @GetMapping(value = "getSchedulesByDishId/{dishId}")
    public ResponseEntity<CollectionModel<ScheduleDto>> getSchedulesByDishId(@PathVariable Integer dishId) {
        List<Schedule> schedules = scheduleService.getSchedulesByDishId(dishId);
        CollectionModel<ScheduleDto> scheduleDto = scheduleDtoAssembler.toCollectionModel(schedules);
        return new ResponseEntity<>(scheduleDto, HttpStatus.OK);
    }

    @GetMapping(value = "getSchedulesBySupplementId/{supplementId}")
    public ResponseEntity<CollectionModel<ScheduleDto>> getSchedulesBySupplementId(@PathVariable Integer supplementId) {
        List<Schedule> schedules = scheduleService.getSchedulesBySupplementId(supplementId);
        CollectionModel<ScheduleDto> scheduleDto = scheduleDtoAssembler.toCollectionModel(schedules);
        return new ResponseEntity<>(scheduleDto, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<ScheduleDto> addSchedule(@RequestBody Schedule schedule) {
        Schedule newSchedule = scheduleService.create(schedule);
        ScheduleDto scheduleDto = scheduleDtoAssembler.toModel(newSchedule);
        return new ResponseEntity<>(scheduleDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{scheduleId}")
    public ResponseEntity<?> updateSchedule(@RequestBody Schedule schedule, @PathVariable Integer scheduleId) {
        scheduleService.update(scheduleId, schedule);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{scheduleId}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer scheduleId) {
        scheduleService.delete(scheduleId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/insert_schedule_dish")
    public void scheduleDishInsertion(Integer dish_id, Integer schedule_id) {
        scheduleService.scheduleDishInsertion(dish_id,schedule_id);
    }
}
