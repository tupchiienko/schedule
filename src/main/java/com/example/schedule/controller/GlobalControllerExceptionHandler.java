package com.example.schedule.controller;

import com.example.schedule.data.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException e) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                Timestamp.from(Instant.now()),
                e.getBindingResult().getFieldErrors().stream()
                        .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                        .collect(Collectors.toList())
        );
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public ErrorResponse handleNoSuchElementExceptions(NoSuchElementException e) {
        return new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                Timestamp.from(Instant.now()),
                List.of(e.getMessage())
        );
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UnsatisfiedServletRequestParameterException.class)
    public ErrorResponse handleUnsatisfiedServletRequestParameterExceptions(
            UnsatisfiedServletRequestParameterException e
    ) {
        return new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                Timestamp.from(Instant.now()),
                List.of(Objects.requireNonNull(e.getMessage()))
        );
    }
}
