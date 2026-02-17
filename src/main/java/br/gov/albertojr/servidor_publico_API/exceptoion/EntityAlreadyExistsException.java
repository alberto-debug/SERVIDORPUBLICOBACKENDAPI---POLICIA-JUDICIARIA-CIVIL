package br.gov.albertojr.servidor_publico_API.exceptoion;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.HTTP_VERSION_NOT_SUPPORTED)
public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(String nome) {
        super(nome);
    }
}
