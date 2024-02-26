package com.springboot.schedular.Exceptions;

public class NoAnyDetailsOfFirstNameException extends  Exception{

    String message;

    public NoAnyDetailsOfFirstNameException(String message)
    {
        super(message);
    }
}
