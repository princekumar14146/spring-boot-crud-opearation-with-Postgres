package com.springboot.schedular.Exceptions;

public class StudentDetailsEmptyException extends Exception{

    String messgae;

    public StudentDetailsEmptyException(String message)
    {
        super(message);
    }


}
