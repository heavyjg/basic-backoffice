package br.com.projetoportfolio.basicbackoffice.exceptions;

public class ItemNotFoundException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = -6809633784037070835L;

    public ItemNotFoundException(Long id) {
        super("Não foi possível encontrar o item "+ id);
    }
    
}