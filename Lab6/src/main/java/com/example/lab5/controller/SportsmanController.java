package com.example.lab5.controller;

import com.example.lab5.domain.Sportsman;
import com.example.lab5.dto.SportsmanDto;
import com.example.lab5.dto.assembler.SportsmanDtoAssembler;
import com.example.lab5.service.SportsmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/sportsmen")
public class SportsmanController {
    @Autowired
    private SportsmanService sportsmanService;

    @Autowired
    private SportsmanDtoAssembler sportsmanDtoAssembler;

    @GetMapping(value = "/{sportsmanId}")
    public ResponseEntity<SportsmanDto> getSportsman(@PathVariable Integer sportsmanId) {
        Sportsman sportsman = sportsmanService.findById(sportsmanId);
        SportsmanDto sportsmanDto = sportsmanDtoAssembler.toModel(sportsman);
        return new ResponseEntity<>(sportsmanDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<SportsmanDto>> getAllSportsmen() {
        List<Sportsman> sportsmen = sportsmanService.findAll();
        CollectionModel<SportsmanDto> sportsmanDtos = sportsmanDtoAssembler.toCollectionModel(sportsmen);
        return new ResponseEntity<>(sportsmanDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/sportsmanSurname/{sportsmanSurname}")
    public ResponseEntity<CollectionModel<SportsmanDto>> getSportsmenBySurname(@PathVariable String sportsmanSurname) {
        List<Sportsman> sportsmen = sportsmanService.findBySurname(sportsmanSurname);
        CollectionModel<SportsmanDto> sportsmanDtos = sportsmanDtoAssembler.toCollectionModel(sportsmen);
        return new ResponseEntity<>(sportsmanDtos, HttpStatus.OK);
    }

    @GetMapping(value = "getSportsmenByScheduleId/{scheduleId}")
    public ResponseEntity<CollectionModel<SportsmanDto>> getSportsmenByScheduleId(@PathVariable Integer scheduleId) {
        List<Sportsman> sportsmen = sportsmanService.getSportsmenByScheduleId(scheduleId);
        CollectionModel<SportsmanDto> sportsmanDtos = sportsmanDtoAssembler.toCollectionModel(sportsmen);
        return new ResponseEntity<>(sportsmanDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<SportsmanDto> addSportsman(@RequestBody Sportsman sportsman) {
        Sportsman newSportsman = sportsmanService.create(sportsman);
        SportsmanDto sportsmanDto = sportsmanDtoAssembler.toModel(newSportsman);
        return new ResponseEntity<>(sportsmanDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{sportsmanId}")
    public ResponseEntity<?> updateDish(@RequestBody Sportsman sportsman, @PathVariable Integer sportsmanId) {
        sportsmanService.update(sportsmanId, sportsman);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{sportsmanId}")
    public ResponseEntity<?> deleteSportsman(@PathVariable Integer sportsmanId) {
        sportsmanService.delete(sportsmanId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
