package br.com.projetoportfolio.basicbackoffice.advices;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.projetoportfolio.basicbackoffice.exceptions.ItemNotFoundException;

@ControllerAdvice
public class ItemNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String itemNotFoundHandler(ItemNotFoundException ex){
        return ex.getMessage();
    }

}