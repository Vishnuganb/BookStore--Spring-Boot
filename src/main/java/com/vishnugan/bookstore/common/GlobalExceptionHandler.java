package com.vishnugan.bookstore.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity handleException ( Exception e ) {
        APIResponse response = new APIResponse ();
        response.setStatus ( HttpStatus.INTERNAL_SERVER_ERROR.value () );
        response.setError ( e.getMessage () );
        return ResponseEntity.status ( HttpStatus.INTERNAL_SERVER_ERROR.value () ).body ( response );
    }

    @ExceptionHandler
    public ResponseEntity handleBadRequestException ( BadRequestException e ) {
        APIResponse response = new APIResponse ();
        response.setStatus ( HttpStatus.BAD_REQUEST.value () );
        response.setError ( e.getErrors () );
        return ResponseEntity.status ( HttpStatus.BAD_REQUEST.value () ).body ( response );
    }

}
