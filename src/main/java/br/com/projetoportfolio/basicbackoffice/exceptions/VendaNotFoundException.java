package br.com.projetoportfolio.basicbackoffice.exceptions;

public class VendaNotFoundException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = -6809633784037070835L;

    public VendaNotFoundException(Long id) {
        super("Não foi possível encontrar a venda "+ id);
    }
    
}