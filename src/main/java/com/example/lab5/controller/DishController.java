package com.example.lab5.controller;

import com.example.lab5.domain.Dish;
import com.example.lab5.dto.DishDto;
import com.example.lab5.dto.assembler.DishDtoAssembler;
import com.example.lab5.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/dishes")
public class DishController {
    @Autowired
    private DishService dishService;
    @Autowired
    private DishDtoAssembler dishDtoAssembler;

    @GetMapping(value = "/{dishId}")
    public ResponseEntity<DishDto> getDish(@PathVariable Integer dishId) {
        Dish dish = dishService.findById(dishId);
        DishDto dishDto = dishDtoAssembler.toModel(dish);
        return new ResponseEntity<>(dishDto, HttpStatus.OK);
    }

    @GetMapping(value = "")
    public ResponseEntity<CollectionModel<DishDto>> getAllDishes() {
        List<Dish> dishes = dishService.findAll();
        CollectionModel<DishDto> dishDtos = dishDtoAssembler.toCollectionModel(dishes);
        return new ResponseEntity<>(dishDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/dishName/{dishName}")
    public ResponseEntity<CollectionModel<DishDto>> getDishesByName(@PathVariable String dishName) {
        List<Dish> dishes = dishService.findByName(dishName);
        CollectionModel<DishDto> dishDtos = dishDtoAssembler.toCollectionModel(dishes);
        return new ResponseEntity<>(dishDtos, HttpStatus.OK);
    }

    @GetMapping(value = "getDishesByScheduleId/{scheduleId}")
    public ResponseEntity<CollectionModel<DishDto>> getDishesByScheduleId(@PathVariable Integer scheduleId) {
        List<Dish> dishes = dishService.getDishesByScheduleId(scheduleId);
        CollectionModel<DishDto> dishDtos = dishDtoAssembler.toCollectionModel(dishes);
        return new ResponseEntity<>(dishDtos, HttpStatus.OK);
    }

    @PostMapping(value = "")
    public ResponseEntity<DishDto> addDish(@RequestBody Dish dish) {
        Dish newDish = dishService.create(dish);
        DishDto dishDto = dishDtoAssembler.toModel(newDish);
        return new ResponseEntity<>(dishDto, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{dishId}")
    public ResponseEntity<?> updateDish(@RequestBody Dish dish, @PathVariable Integer dishId) {
        dishService.update(dishId, dish);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{dishId}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer dishId) {
        dishService.delete(dishId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/insert_dish")
    public ResponseEntity<?> insertDish(@RequestBody Dish dish) {
        dishService.dishInsertion(dish.getName(),dish.getComponents(),dish.getCalories(),dish.getManufacturer(),dish.getProductionDate(),dish.getConsumptionDate());
        DishDto dishDto = dishDtoAssembler.toModel(dish);
        return new ResponseEntity<>(dishDto, HttpStatus.CREATED);
    }

    @PostMapping(value = "/insert_schedule_dish")
    public void scheduleDishInsertion(Integer dish_id, Integer schedule_id) {
        dishService.scheduleDishInsertion(dish_id,schedule_id);
    }

    @PostMapping(value = "/insertion_ten_dishes")
    public void insertionTenDishes() {
        dishService.insertionTenDishes();
    }

    @GetMapping(value = "/get_dish_min_calories")
    public Integer printMinCountOfCalories(){
        return dishService.printMinCountOfCalories();
    };


    @PostMapping(value = "/create_tables")
    public void createTables(){
        dishService.createTables();
    };
}
