package br.gov.albertojr.servidor_publico_API.Home;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @GetMapping("/")
    public Map<String, Object> HomePage(){

        Map<String, Object> response = new HashMap<>();
        response.put("name", "Servidor Publico");
        response.put("version", "1.0.0");
        response.put("status", "running");




        return response;

    }
}
