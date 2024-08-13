package org.adem.hospitalmanagement.exception;

public class PrescriptionNotFoundException extends RuntimeException{
    public PrescriptionNotFoundException(String message) {
        super(message);
    }
}
