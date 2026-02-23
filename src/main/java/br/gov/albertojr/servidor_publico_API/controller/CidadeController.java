package br.gov.albertojr.servidor_publico_API.controller;

import br.gov.albertojr.servidor_publico_API.business.CidadeBusiness;

import br.gov.albertojr.servidor_publico_API.model.Cidade;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeBusiness cidadeBusiness;

    @PostMapping("/add")
    public ResponseEntity<Cidade> add(@RequestBody Cidade cidade){

        Cidade created = cidadeBusiness.add(cidade);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(created);
    }

    @GetMapping("/all")
    public ResponseEntity<Page<Cidade>> findAll(Pageable pageable){
        return ResponseEntity.ok(cidadeBusiness.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> findById(@PathVariable int id){
        return ResponseEntity.ok(cidadeBusiness.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cidade> update(@PathVariable int id, @RequestBody Cidade cidade){

        return ResponseEntity.ok(cidadeBusiness.update(id,cidade));
    }

}
