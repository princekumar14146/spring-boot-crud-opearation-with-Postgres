package com.springboot.schedular.Exceptions;

public class NoSuchIdAvailableInDatabase extends  Exception{

    String message;

    public NoSuchIdAvailableInDatabase(String message)
    {
        super(message);
    }
}
