package com.demmage.cibinternstesttask.controller;

import com.demmage.cibinternstesttask.exception.BadSocksException;
import com.demmage.cibinternstesttask.exception.NoSuchOperationException;
import com.demmage.cibinternstesttask.exception.NoSuchSocksQuantityException;
import com.demmage.cibinternstesttask.exception.SocksNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Vadim Guseynov
 */

@RestControllerAdvice
public class ControllerAdviser {

    @ExceptionHandler(value = BadSocksException.class)
    public ResponseEntity<String> handle(BadSocksException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = SocksNotFoundException.class)
    public ResponseEntity<String> handle(SocksNotFoundException e) {
        return new ResponseEntity<>("Socks not found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = NoSuchSocksQuantityException.class)
    public ResponseEntity<String> handle(NoSuchSocksQuantityException e) {
        return new ResponseEntity<>("No such socks quantity", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = NoSuchOperationException.class)
    public ResponseEntity<String> handle(NoSuchOperationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> handle(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}