package com.driver.Exceptions;

public class DriverNotFoundException extends RuntimeException{

    public DriverNotFoundException(String message){
        super(message);
    }
}
