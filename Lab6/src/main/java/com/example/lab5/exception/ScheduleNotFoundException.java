package com.example.lab5.exception;

public class ScheduleNotFoundException extends RuntimeException{
    public ScheduleNotFoundException(Integer id) {
        super("Could not find 'schedule' with id=" + id);
    }
}
