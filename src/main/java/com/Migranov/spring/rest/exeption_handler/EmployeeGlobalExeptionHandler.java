package com.Migranov.spring.rest.exeption_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class EmployeeGlobalExeptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeInCorrectData> handleExeption(NoSuchEmployeeExeption exeption){
        EmployeeInCorrectData data=new EmployeeInCorrectData();
        data.setInfo(exeption.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<EmployeeInCorrectData> handleExeption(Exception exeption){
        EmployeeInCorrectData data=new EmployeeInCorrectData();
        data.setInfo(exeption.getMessage());
        return new ResponseEntity<>(data,HttpStatus.BAD_REQUEST);
    }
}
