package br.gov.albertojr.servidor_publico_API.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException {


    @ExceptionHandler(EntityDoesNotExistsException.class)
    public ResponseEntity<Void> handleNotFound(EntityDoesNotExistsException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<Void> handleConflict(EntityAlreadyExistsException e) {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
