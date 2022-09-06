package com.jojo.springbootrestapi.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalAccessError.class)
    public final ResponseEntity<ExceptionResponse> illegalException (Exception exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),"1000",exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(UserNotFound.class)
    public final ResponseEntity<ExceptionResponse> userNotFound (Exception exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),"2000",exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> exception (Exception exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(),"5000",exception.getMessage());
        return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.EXPECTATION_FAILED);
    }

}
