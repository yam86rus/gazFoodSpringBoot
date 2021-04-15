package com.gazfood.gazfoodspringboot.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class VacancyGlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<VacanciesIncorrectData> handlerException(
            NoSuchVacancyException exception
    ) {
        VacanciesIncorrectData data = new VacanciesIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<CitiesIncorrectData> handlerException(
            NoSuchCityException exception
    ) {
        CitiesIncorrectData data = new CitiesIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<VacanciesIncorrectData> handlerException(
            Exception exception
    ) {
        VacanciesIncorrectData data = new VacanciesIncorrectData();
        data.setInfo(exception.getMessage());

        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
