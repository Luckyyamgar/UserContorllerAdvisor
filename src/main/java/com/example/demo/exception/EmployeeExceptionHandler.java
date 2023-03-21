package com.example.demo.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ErrorMessage methodArgumentsNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getBindingResult().getFieldError().getDefaultMessage(), "Invalid data");
        return errorMessage;
    }

    @ExceptionHandler(value = InvalidUrlException.class)
    public ErrorMessage invalidUrlExceptionHandler(InvalidUrlException exception) {
        ErrorMessage errorMessage = new ErrorMessage(exception.getMessage(), "Invalid URL");
        return errorMessage;
    }

}
