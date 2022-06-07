package edu.bzu.app.restapi.exceptions;

public class BadRequest extends RuntimeException{
    public BadRequest(String message) {
        super(message);
    }

    public BadRequest(String message, Throwable cause) {
        super(message, cause);
    }
}
