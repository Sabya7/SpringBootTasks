package com.stackroute.boot.muzix;

import io.swagger.models.Model;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> custom(Exception e)
    {

        return new ResponseEntity<String>("hi , NO such page exists", HttpStatus.NOT_FOUND);
    }
}
