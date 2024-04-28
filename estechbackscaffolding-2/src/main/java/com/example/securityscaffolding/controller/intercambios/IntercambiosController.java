package com.example.securityscaffolding.controller.intercambios;

import com.example.securityscaffolding.dto.IntercambiosDTO;
import com.example.securityscaffolding.model.entity.LibrosPrestados;
import com.example.securityscaffolding.security.service.IntercambiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/intercambios")
public class IntercambiosController {

    @Autowired
    private IntercambiosService intercambiosService;

    //Lista todos intercambios
    @GetMapping
    public List<IntercambiosDTO> listaIntercambios(){
        return intercambiosService.listaIntercambios();
    }

    //Lista intercambios del usuario
    @GetMapping("/usuario/{id}")
    public List<IntercambiosDTO> listaIntercambiosUsuario(@PathVariable Long id){
        return intercambiosService.listaIntercambiosUsuario(id);
    }

    //Post intercambio
    @PostMapping
    public IntercambiosDTO postIntercambio(@RequestBody LibrosPrestados librosPrestados){
        return intercambiosService.postIntercambio(librosPrestados);
    }
}
