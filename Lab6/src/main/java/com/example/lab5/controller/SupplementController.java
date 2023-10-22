package com.example.lab5.controller;

import com.example.lab5.domain.Supplement;
import com.example.lab5.dto.SupplementDto;
import com.example.lab5.dto.assembler.SupplementDtoAssembler;
import com.example.lab5.service.SupplementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/supplements")
public class SupplementController {
    @Autowired
    private SupplementService supplementService;
    @Autowired
    private SupplementDtoAssembler supplementDtoAssembler;

    @GetMapping(value = "/{supplementId}")
    public ResponseEntity<SupplementDto> getSupplement(@PathVariable Integer supplementId) {
        Supplement supplement = supplementService.findById(supplementId);
        SupplementDto supplementDto = supplementDtoAssembler.toModel(supplement);
        return new ResponseEntity<>(supplementDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<SupplementDto>> getAllSupplements() {
        List<Supplement> supplements = supplementService.findAll();
        CollectionModel<SupplementDto> supplementDtos = supplementDtoAssembler.toCollectionModel(supplements);
        return new ResponseEntity<>(supplementDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/supplementName/{supplementName}")
    public ResponseEntity<CollectionModel<SupplementDto>> getSupplementsByName(@PathVariable String supplementName) {
        List<Supplement> supplements = supplementService.findByName(supplementName);
        CollectionModel<SupplementDto> supplementDtos = supplementDtoAssembler.toCollectionModel(supplements);
        return new ResponseEntity<>(supplementDtos, HttpStatus.OK);
    }

    @GetMapping(value = "getSupplementsByScheduleId/{scheduleId}")
    public ResponseEntity<CollectionModel<SupplementDto>> getSupplementsByScheduleId(@PathVariable Integer scheduleId) {
        List<Supplement> supplements = supplementService.getSupplementsByScheduleId(scheduleId);
        CollectionModel<SupplementDto> supplementDtos = supplementDtoAssembler.toCollectionModel(supplements);
        return new ResponseEntity<>(supplementDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<SupplementDto> addSupplement(@RequestBody Supplement supplement) {
        Supplement newSupplement = supplementService.create(supplement);
        SupplementDto supplementDto = supplementDtoAssembler.toModel(newSupplement);
        return new ResponseEntity<>(supplementDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{supplementId}")
    public ResponseEntity<?> updateSupplement(@RequestBody Supplement supplement, @PathVariable Integer supplementId) {
        supplementService.update(supplementId, supplement);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{supplementId}")
    public ResponseEntity<?> deleteSupplement(@PathVariable Integer supplementId) {
        supplementService.delete(supplementId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
