package com.driver.Exceptions;

public class AdminNotFoundException extends RuntimeException{

    public AdminNotFoundException(String message){
        super(message);
    }
}
