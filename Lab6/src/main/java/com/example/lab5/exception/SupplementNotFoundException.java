package com.example.lab5.exception;

public class SupplementNotFoundException extends RuntimeException{
    public SupplementNotFoundException(Integer id){
        super("Could not find 'supplement' with id=" + id);
    }
}
