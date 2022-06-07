package edu.bzu.app.restapi.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
@AllArgsConstructor
@Data
public class ApiExep {
    private final String message;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timestamp;
}
