package com.hospitalmanagement.hospital_management.exception;


import org.springframework.http.HttpStatus;

public class HospitalMException {
    private final String message;
    private  final  Throwable throwable;
    private  final HttpStatus httpStatus;

    public Throwable getThrowable() {
        return throwable;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public HospitalMException(String message, Throwable throwable, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
    }


}
