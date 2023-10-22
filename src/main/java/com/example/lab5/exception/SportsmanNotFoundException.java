package com.example.lab5.exception;

public class SportsmanNotFoundException extends RuntimeException{
    public SportsmanNotFoundException(Integer id) {
        super("Could not find 'sportsman' with id=" + id);
    }
}
