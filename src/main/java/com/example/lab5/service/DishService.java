package com.example.lab5.service;

import com.example.lab5.domain.Dish;
import org.springframework.data.jpa.repository.query.Procedure;

import java.util.Date;
import java.util.List;

public interface DishService extends GeneralService<Dish, Integer>{
    List<Dish> findByName(String name);

    List<Dish> getDishesByScheduleId(Integer scheduleId);

    void dishInsertion(String name, String components, Integer calories, String manufacturer, Date production_date, Date consumption_date);

    void scheduleDishInsertion(Integer dish_id, Integer schedule_id);

    void insertionTenDishes();

    Integer printMinCountOfCalories();

    void createTables();
}
