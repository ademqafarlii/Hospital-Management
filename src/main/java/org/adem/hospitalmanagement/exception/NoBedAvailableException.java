package org.adem.hospitalmanagement.exception;

public class NoBedAvailableException extends RuntimeException{
    public NoBedAvailableException(String message) {
        super(message);
    }
}
