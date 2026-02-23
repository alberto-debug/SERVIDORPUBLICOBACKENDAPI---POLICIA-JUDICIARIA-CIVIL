package br.gov.albertojr.servidor_publico_API.controller;


import br.gov.albertojr.servidor_publico_API.business.UnidadeBusiness;
import br.gov.albertojr.servidor_publico_API.model.Unidade;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/unidade")
public class UnidadeBController {

    @Autowired
    private UnidadeBusiness unidadeBusiness;


}
