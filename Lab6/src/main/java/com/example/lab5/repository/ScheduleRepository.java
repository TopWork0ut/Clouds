package com.example.lab5.repository;

import com.example.lab5.domain.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
    @Procedure(procedureName = "scheduleDishInsertion")
    void scheduleDishInsertion(Integer dish_id, Integer schedule_id);
}
