package com.hospitalmanagement.hospital_management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class HospitalExceptionHandler {
    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> handleHospitalMnotFoundException(NotFoundException notFoundException)
    {
        HospitalMException hospitalMException= new HospitalMException(
                notFoundException.getMessage(),
                notFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );
        return  new ResponseEntity<>(hospitalMException,HttpStatus.NOT_FOUND);
    }

}
