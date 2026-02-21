package br.gov.albertojr.servidor_publico_API.exception;

import java.io.Serial;

public class EntityAlreadyExistsException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public EntityAlreadyExistsException(String nome) {
        super(nome + " already exists");
    }
}
