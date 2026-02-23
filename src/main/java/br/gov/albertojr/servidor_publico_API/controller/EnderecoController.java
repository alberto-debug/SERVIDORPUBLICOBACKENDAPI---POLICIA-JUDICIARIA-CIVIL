package br.gov.albertojr.servidor_publico_API.controller;


import br.gov.albertojr.servidor_publico_API.business.EnderecoBusiness;
import br.gov.albertojr.servidor_publico_API.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoBusiness enderecoBusiness;

    public ResponseEntity<Endereco> add(@RequestBody Endereco endereco){


        Endereco created = enderecoBusiness.add(endereco);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(endereco.getId())
                .toUri();

        return ResponseEntity.created(location).body(created);


        //return ResponseEntity.ok(enderecoBusiness.add(endereco));
    }

    public ResponseEntity<Page<Endereco>> findAll(Pageable pageable){

        return ResponseEntity.ok(enderecoBusiness.findAll(pageable));
    }

    public ResponseEntity<Endereco> findById(@PathVariable int id){

        return ResponseEntity.ok(enderecoBusiness.findById(id));
    }

    public ResponseEntity<Endereco> update( @PathVariable int id,@RequestBody Endereco endereco){

        return ResponseEntity.ok(enderecoBusiness.update(id, endereco));
    }
}
