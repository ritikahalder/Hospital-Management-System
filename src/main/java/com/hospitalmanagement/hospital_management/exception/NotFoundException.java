package com.hospitalmanagement.hospital_management.exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class NotFoundException  extends  RuntimeException{

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
