package com.example.securityscaffolding.controller.deseos;

import com.example.securityscaffolding.dto.DeseosDTO;
import com.example.securityscaffolding.model.entity.Deseos;
import com.example.securityscaffolding.security.service.DeseosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/deseos")
public class DeseosController {

    @Autowired
    private DeseosService deseosService;

    @GetMapping
    public List<DeseosDTO> listaDeseos(){
        return deseosService.listaDeseos();
    }

    @GetMapping("/usuario/{id}")
    public List<DeseosDTO> listaDeseosUsuario(@PathVariable Long id){
        return deseosService.listaDeseosUsuario(id);
    }

    @PostMapping
    public DeseosDTO postDeseo(@RequestBody Deseos deseos){
        return deseosService.postDeseo(deseos);
    }
}
