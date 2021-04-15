package com.gazfood.gazfoodspringboot.exception_handling;

public class NoSuchCityException extends RuntimeException{
    public NoSuchCityException(String message) {
        super(message);
    }
}
