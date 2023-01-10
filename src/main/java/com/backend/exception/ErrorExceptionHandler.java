package com.backend.exception;


import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ErrorExceptionHandler {

    private final Logger log = LoggerFactory.getLogger(ErrorExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        log.warn("Erro: " + ex.getMessage());
        return errors;
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    public String ObjectNotFoundException(ObjectNotFoundException  ex) {

        log.warn("Erro: " + ex.getMessage());
        return   ex.getMessage() ;

    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidDefinitionException.class)
    public String InvalidDefinitionException(InvalidDefinitionException  ex) {

        log.warn("Erro: " + ex.getMessage());
        return   ex.getMessage() ;

    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public String ConstraintViolationException(ConstraintViolationException  ex) {

        log.warn("Erro: " + ex.getMessage());
        return   ex.getMessage() ;

    }
}
