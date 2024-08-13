package org.adem.hospitalmanagement.exception;

public class BedNotFoundException extends RuntimeException{
    public BedNotFoundException(String message) {
        super(message);
    }
}
