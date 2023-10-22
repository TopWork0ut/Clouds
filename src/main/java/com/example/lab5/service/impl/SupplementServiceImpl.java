package com.example.lab5.service.impl;

import com.example.lab5.domain.Schedule;
import com.example.lab5.domain.Supplement;
import com.example.lab5.exception.DishNotFoundException;
import com.example.lab5.exception.ScheduleNotFoundException;
import com.example.lab5.exception.SupplementNotFoundException;
import com.example.lab5.repository.ScheduleRepository;
import com.example.lab5.repository.SupplementRepository;
import com.example.lab5.service.SupplementService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplementServiceImpl implements SupplementService {
    @Autowired
    SupplementRepository supplementRepository;
    @Autowired
    ScheduleRepository scheduleRepository;

    public Supplement findById(Integer id) {
        return supplementRepository.findById(id)
                .orElseThrow(() -> new SupplementNotFoundException(id));
    }

    public List<Supplement> findAll() {
        return supplementRepository.findAll();
    }

    public List<Supplement> findByName(String name) {
        return supplementRepository.findByName(name);
    }

    public List<Supplement> getSupplementsByScheduleId(Integer scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId).orElseThrow(() -> new ScheduleNotFoundException(scheduleId));
        return schedule.getSupplements().stream().toList();
    }

    @Transactional
    public Supplement create(Supplement supplement) {
        supplementRepository.save(supplement);
        return supplement;
    }

    @Transactional
    public void update(Integer id, Supplement supplementParam) {
        Supplement supplement = supplementRepository.findById(id)
                .orElseThrow(() -> new SupplementNotFoundException(id));
        supplement.setName(supplementParam.getName());
        supplement.setComponents(supplementParam.getComponents());
        supplement.setCalories(supplementParam.getCalories());
        supplement.setManufacturer(supplementParam.getManufacturer());
        supplement.setProductionDate(supplementParam.getProductionDate());
        supplement.setConsumptionDate(supplementParam.getConsumptionDate());
        supplementRepository.save(supplement);
    }

    @Transactional
    public void delete(Integer id) {
        Supplement supplement = supplementRepository.findById(id)
                .orElseThrow(() -> new SupplementNotFoundException(id));
        supplementRepository.delete(supplement);
    }
}
