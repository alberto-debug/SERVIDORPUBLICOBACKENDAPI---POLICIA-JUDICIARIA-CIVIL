package br.gov.albertojr.servidor_publico_API.exceptoion;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityDoesNotExistsException extends RuntimeException{

    @Serial
    private static final long serialVersionUID= 1L;

    public EntityDoesNotExistsException(String id){
        super("Entity with id: "+ id + "Does not exist");
    }
}
