package com.example.lab5.service;

import com.example.lab5.domain.Supplement;

import java.util.List;

public interface SupplementService extends GeneralService<Supplement, Integer>{
    List<Supplement> findByName(String name);

    List<Supplement> getSupplementsByScheduleId(Integer scheduleId);
}
