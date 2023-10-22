package com.example.lab5.service;

import com.example.lab5.domain.Dish;
import com.example.lab5.domain.Schedule;

import java.util.List;

public interface ScheduleService extends GeneralService<Schedule, Integer>{
    List<Schedule> getSchedulesByDishId(Integer dishId);

    List<Schedule> getSchedulesBySupplementId(Integer supplementId);

    void scheduleDishInsertion(Integer dish_id, Integer schedule_id);
}
