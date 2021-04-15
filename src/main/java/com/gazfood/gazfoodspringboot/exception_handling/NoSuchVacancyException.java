package com.gazfood.gazfoodspringboot.exception_handling;

public class NoSuchVacancyException extends RuntimeException{
    public NoSuchVacancyException(String message) {
        super(message);
    }
}
