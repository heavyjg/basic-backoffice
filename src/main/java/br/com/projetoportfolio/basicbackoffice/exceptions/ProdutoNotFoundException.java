package br.com.projetoportfolio.basicbackoffice.exceptions;

public class ProdutoNotFoundException extends RuntimeException{

    /**
     *
     */
    private static final long serialVersionUID = -6809633784037070835L;

    public ProdutoNotFoundException(Long id) {
        super("Não foi possível encontrar o produto "+ id);
    }
    
}