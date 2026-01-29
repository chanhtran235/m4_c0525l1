package org.example.demo_spring_data_jpa.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class GlobalExceptionController {
    @ExceptionHandler(NoResourceFoundException.class)
    public String notFound(){
        return "not-found";
    }
}
