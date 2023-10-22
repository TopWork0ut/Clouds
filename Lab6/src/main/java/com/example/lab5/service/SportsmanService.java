package com.example.lab5.service;

import com.example.lab5.domain.Sportsman;

import java.util.List;

public interface SportsmanService extends GeneralService<Sportsman, Integer>{
    List<Sportsman> findBySurname(String surname);

    List<Sportsman>getSportsmenByScheduleId(Integer scheduleId);
}
