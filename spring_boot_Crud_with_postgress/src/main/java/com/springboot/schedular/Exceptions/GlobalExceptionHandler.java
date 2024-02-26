package com.springboot.schedular.Exceptions;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentDetailsEmptyException.class)
    public ResponseEntity<String> handleStudentDetailsEmptyException(StudentDetailsEmptyException ex)
    {
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(NoAnyDetailsOfFirstNameException.class)
    public ResponseEntity<String> handleNoAnyDetailsOfFirstNameException(NoAnyDetailsOfFirstNameException ex)
    {
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String,String>>  handleConstraintViolationException(ConstraintViolationException ex)
    {
        Map<String,String> errors=new HashMap<>();
        ex.getConstraintViolations().forEach((error)->{
            String fielsName= error.getPropertyPath().toString();
            String errorMessage=error.getMessage();
            errors.put(fielsName, errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }

    @ExceptionHandler(NoSuchDepartmentAvailableException.class)
    public ResponseEntity<String> handleNoSuchDepartmentAvailableException(NoSuchDepartmentAvailableException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

}
