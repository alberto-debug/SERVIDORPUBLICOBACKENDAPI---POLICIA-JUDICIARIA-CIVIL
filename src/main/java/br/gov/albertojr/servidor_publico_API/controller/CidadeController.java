package br.gov.albertojr.servidor_publico_API.controller;


import br.gov.albertojr.servidor_publico_API.business.CidadeBusiness;
import br.gov.albertojr.servidor_publico_API.exceptoion.EntityDoesNotExistsException;
import br.gov.albertojr.servidor_publico_API.model.Cidade;
import br.gov.albertojr.servidor_publico_API.repository.CidadeRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeBusiness cidadeBusiness;

    @PostMapping("/add")
    public ResponseEntity<Cidade> addCidade(@RequestBody @Valid Cidade cidade){

        Cidade created = cidadeBusiness.add(cidade);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

       return ResponseEntity.created(location).body(created);

        //return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping("/get")
    public ResponseEntity<Page<Cidade>> getAll(Pageable pageable){

        return ResponseEntity.ok(cidadeBusiness.findAll(pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cidade> getById(@PathVariable int id){

        return ResponseEntity.ok(cidadeBusiness.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> updateCidade(
            @RequestBody int id,
            @RequestBody Cidade cidade){

       try{
           Cidade updated = cidadeBusiness.update(id, cidade);

           return ResponseEntity.ok(updated);
       } catch (EntityDoesNotExistsException e){

           return  ResponseEntity.notFound().build();

       }
        //return ResponseEntity.ok(cidadeBusiness.update(cidade));
    }




}
