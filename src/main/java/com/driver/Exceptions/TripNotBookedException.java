package com.driver.Exceptions;

public class TripNotBookedException extends RuntimeException{

    public TripNotBookedException(String message){
        super(message);
    }
}
