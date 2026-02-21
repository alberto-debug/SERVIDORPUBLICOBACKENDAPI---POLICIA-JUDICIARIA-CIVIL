package br.gov.albertojr.servidor_publico_API.controller;


import br.gov.albertojr.servidor_publico_API.business.UnidadeBusiness;
import br.gov.albertojr.servidor_publico_API.model.Unidade;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/unidade")
public class UnidadeBController {


    @Autowired
    private UnidadeBusiness unidadeBusiness;

    @PostMapping("/add")
    private ResponseEntity<Unidade> addunidade(@RequestBody @Valid  Unidade unidade){

        Unidade create= unidadeBusiness.add(unidade);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(create.getId())
                .toUri();


        return ResponseEntity.created(location).body(create);

    }
}
