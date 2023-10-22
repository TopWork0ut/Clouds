package com.example.lab5.exception;

public class ScheduleHasNoSupplementException extends RuntimeException{
    public ScheduleHasNoSupplementException(Integer supplementId, Integer scheduleId){
        super("'schedule' with id=" + scheduleId +  " already have 'supplement' with id=" + supplementId);
    }
}
