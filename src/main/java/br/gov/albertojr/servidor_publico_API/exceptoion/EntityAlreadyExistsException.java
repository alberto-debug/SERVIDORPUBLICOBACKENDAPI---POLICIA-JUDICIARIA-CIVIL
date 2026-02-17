package br.gov.albertojr.servidor_publico_API.exceptoion;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class EntityAlreadyExistsException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public EntityAlreadyExistsException(String nome) {
        super(nome + "Already exists");
    }
}
