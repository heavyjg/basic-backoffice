package br.com.projetoportfolio.basicbackoffice.exceptions;

public class ClienteNotFoundException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = -3008560493526147915L;

    public ClienteNotFoundException(Long id) {
        super("Não foi possível encontrar o cliente "+ id);
    }
    
}