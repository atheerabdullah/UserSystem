package com.example.homeworkspringboot.ApiException;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
