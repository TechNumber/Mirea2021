package com.mirea.demo.controller;

import com.mirea.demo.exception.RequestNotFoundException;
import com.mirea.demo.model.dto.DemoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAdvisor {
    @ExceptionHandler(value = {RequestNotFoundException.class})
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public DemoResponse<Void> handlePetHelperException(RuntimeException ex) {
        return DemoResponse.error(ex.getMessage(), null);
    }
}
