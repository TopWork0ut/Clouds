package com.example.lab5.exception;

public class ScheduleHasNoDishException extends RuntimeException{
    public ScheduleHasNoDishException(Integer dishId, Integer scheduleId){
        super("'schedule' with id=" + scheduleId +  " already have 'dish' with id=" + dishId);
    }
}
