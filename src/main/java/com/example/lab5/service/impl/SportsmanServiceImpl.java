package com.example.lab5.service.impl;

import com.example.lab5.domain.Schedule;
import com.example.lab5.domain.Sportsman;
import com.example.lab5.exception.DishNotFoundException;
import com.example.lab5.exception.ScheduleNotFoundException;
import com.example.lab5.exception.SportsmanNotFoundException;
import com.example.lab5.repository.ScheduleRepository;
import com.example.lab5.repository.SportsmanRepository;
import com.example.lab5.service.SportsmanService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportsmanServiceImpl implements SportsmanService {
    @Autowired
    SportsmanRepository sportsmanRepository;
    @Autowired
    ScheduleRepository scheduleRepository;

    public Sportsman findById(Integer id) {
        return sportsmanRepository.findById(id)
                .orElseThrow(() -> new SportsmanNotFoundException(id));
    }

    public List<Sportsman> findAll() {
        return sportsmanRepository.findAll();
    }

    public List<Sportsman> findBySurname(String surname) {
        return sportsmanRepository.findBySurname(surname);
    }

    public List<Sportsman>getSportsmenByScheduleId(Integer scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new ScheduleNotFoundException(scheduleId));
        return schedule.getSportsmen().stream().toList();
    }

    @Transactional
    public Sportsman create(Sportsman sportsman) {
        sportsmanRepository.save(sportsman);
        return sportsman;
    }

    @Transactional
    public void update(Integer id, Sportsman sportsmanParam) {
        Sportsman sportsman = sportsmanRepository.findById(id)
                .orElseThrow(() -> new DishNotFoundException(id));
        sportsman.setName(sportsmanParam.getName());
        sportsman.setSurname(sportsmanParam.getSurname());
        sportsman.setKindOfSport(sportsmanParam.getKindOfSport());
        sportsman.setHeight(sportsmanParam.getHeight());
        sportsman.setWeight(sportsmanParam.getWeight());
        sportsman.setDoctor_id(sportsmanParam.getDoctor_id());
        sportsmanRepository.save(sportsman);
    }

    @Transactional
    public void delete(Integer id) {
        Sportsman sportsman = sportsmanRepository.findById(id)
                .orElseThrow(() -> new SportsmanNotFoundException(id));
        sportsmanRepository.delete(sportsman);
    }
}
