package br.com.projetoportfolio.basicbackoffice.advices;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.projetoportfolio.basicbackoffice.exceptions.ClienteNotFoundException;

@ControllerAdvice
public class ClienteNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(ClienteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String clienteNotFoundHandler(ClienteNotFoundException ex){
        return ex.getMessage();
    }

    
}