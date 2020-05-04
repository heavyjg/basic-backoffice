package br.com.projetoportfolio.basicbackoffice.advices;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.projetoportfolio.basicbackoffice.exceptions.VendaNotFoundException;

@ControllerAdvice
public class VendaNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(VendaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String itemNotFoundHandler(VendaNotFoundException ex){
        return ex.getMessage();
    }

}