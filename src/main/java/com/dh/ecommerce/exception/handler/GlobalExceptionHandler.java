package com.dh.ecommerce.exception.handler;

import com.dh.ecommerce.exception.CadastroInvalidoException;
import com.dh.ecommerce.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<String> processarErrorResourceNotFound(ResourceNotFoundException exception){
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({CadastroInvalidoException.class})
    public ResponseEntity<String> processarCadastroInvalido(CadastroInvalidoException exception){
        return new  ResponseEntity(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
