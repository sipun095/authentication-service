package com.sp.exception;

import com.sp.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handelUserNotFoundException(UserNotFoundException exception){
        ErrorResponse response= new ErrorResponse(HttpStatus.NOT_FOUND.value(),exception.getMessage()) ;
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }

}
