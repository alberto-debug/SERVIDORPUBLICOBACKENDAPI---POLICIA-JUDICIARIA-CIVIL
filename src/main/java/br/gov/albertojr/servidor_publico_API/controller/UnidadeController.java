package br.gov.albertojr.servidor_publico_API.controller;


import br.gov.albertojr.servidor_publico_API.business.UnidadeBusiness;
import br.gov.albertojr.servidor_publico_API.model.Unidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/unidade")
public class UnidadeController {

    @Autowired
    private UnidadeBusiness unidadeBusiness;

    public ResponseEntity<Unidade> add(@RequestBody Unidade unidade){

        Unidade created = unidadeBusiness.add(unidade);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id{")
                .buildAndExpand(unidade.getId())
                .toUri();

        return ResponseEntity.created(location).body(created);
    }

    public ResponseEntity<Page<Unidade>> findAll(Pageable pageable){
        return ResponseEntity.ok(unidadeBusiness.findAll(pageable));
    }

    public ResponseEntity<Unidade> findById(@PathVariable int id){

        return ResponseEntity.ok(unidadeBusiness.findById(id));
    }

    public ResponseEntity<Unidade> update(@RequestBody Unidade unidade, @PathVariable int id){

        return ResponseEntity.ok(unidadeBusiness.update(id, unidade));

    }
}
