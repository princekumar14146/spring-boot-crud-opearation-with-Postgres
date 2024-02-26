package com.springboot.schedular.Exceptions;

public class DatabaseEmptyException extends Exception{

    String message;

    public DatabaseEmptyException(String message)
    {
        super(message);
    }

}
