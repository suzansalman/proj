package edu.bzu.app.restapi.exceptions;

public class ApiRequestExeption extends RuntimeException{
    public ApiRequestExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiRequestExeption(String message) {
        super(message);
    }
}
