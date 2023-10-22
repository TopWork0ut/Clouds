package com.example.lab5.service.impl;

import com.example.lab5.domain.Dish;
import com.example.lab5.domain.Schedule;
import com.example.lab5.domain.Sportsman;
import com.example.lab5.domain.Supplement;
import com.example.lab5.exception.*;
import com.example.lab5.repository.DishRepository;
import com.example.lab5.repository.ScheduleRepository;
import com.example.lab5.repository.SportsmanRepository;
import com.example.lab5.repository.SupplementRepository;
import com.example.lab5.service.ScheduleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    SportsmanRepository sportsmanRepository;

    @Autowired
    SupplementRepository supplementRepository;

    @Autowired
    DishRepository dishRepository;

    public Schedule findById(Integer id) {
        return scheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException(id));
    }

    public List<Schedule> findAll() {
        return scheduleRepository.findAll();
    }

    @Transactional
    public Schedule create(Schedule schedule) {
        scheduleRepository.save(schedule);
        return schedule;
    }


    @Transactional
    public void update(Integer scheduleId, Schedule scheduleParam) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new ScheduleNotFoundException(scheduleId));
        schedule.setStartDieting(scheduleParam.getStartDieting());
        schedule.setEndDieting(scheduleParam.getEndDieting());
        schedule.setDescription(scheduleParam.getDescription());
        scheduleRepository.save(schedule);
    }


    @Transactional
    public void delete(Integer id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ScheduleNotFoundException(id));
        scheduleRepository.delete(schedule);
    }

    public Schedule findScheduleBySportsmanId(Integer sportsmanId) {
        Sportsman sportsman = sportsmanRepository.findById(sportsmanId)
                .orElseThrow(() -> new SportsmanNotFoundException(sportsmanId));
        return sportsman.getSchedule();
    }

    public List<Schedule> getSchedulesByDishId(Integer dishId) {
        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new DishNotFoundException(dishId));
        return dish.getSchedules().stream().toList();
    }

    public List<Schedule> getSchedulesBySupplementId(Integer supplementId) {
        Supplement supplement = supplementRepository.findById(supplementId)
                .orElseThrow(() -> new SupplementNotFoundException(supplementId));
        return supplement.getSchedules().stream().toList();
    }

    @Override
    public void scheduleDishInsertion(Integer dish_id, Integer schedule_id) {
        scheduleRepository.scheduleDishInsertion(dish_id, schedule_id);
    }
}
