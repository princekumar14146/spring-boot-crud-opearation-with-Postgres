package com.springboot.schedular.Exceptions;

public class NoSuchDepartmentAvailableException extends Exception{

    String message;

    public NoSuchDepartmentAvailableException(String message)
    {
        super(message);
    }
}
