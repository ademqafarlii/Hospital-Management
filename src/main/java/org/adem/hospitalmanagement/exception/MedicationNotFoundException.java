package org.adem.hospitalmanagement.exception;

public class MedicationNotFoundException extends RuntimeException{
    public MedicationNotFoundException(String message) {
        super(message);
    }
}
