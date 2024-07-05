package com.driver.Exceptions;

public class CabNotFoundException extends RuntimeException {

    public CabNotFoundException(String message){
        super(message);
    }
}
