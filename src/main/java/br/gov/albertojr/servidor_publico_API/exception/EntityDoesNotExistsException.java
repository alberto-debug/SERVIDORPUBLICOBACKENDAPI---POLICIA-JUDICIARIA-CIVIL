package br.gov.albertojr.servidor_publico_API.exception;


import java.io.Serial;

public class EntityDoesNotExistsException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public EntityDoesNotExistsException(int id) {
        super("Entity with id: " + id + " does not exist");
    }
}
