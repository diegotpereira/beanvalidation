package br.com.java.beanvalidation.controller.advice;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@ControllerAdvice
public class ControlAdvice {
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public String handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        return "Campo: " +
        ex.getBindingResult().getFieldError().getField() + " - Descrição erro: " +
        ex.getBindingResult().getFieldError().getDefaultMessage();
    }

}
