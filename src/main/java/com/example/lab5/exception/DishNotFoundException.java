package com.example.lab5.exception;

public class DishNotFoundException extends RuntimeException{
    public DishNotFoundException(Integer id){
        super("Could not find 'dish' with id=" + id);
    }
}
