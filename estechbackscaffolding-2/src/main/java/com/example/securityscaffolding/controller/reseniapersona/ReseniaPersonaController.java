package com.example.securityscaffolding.controller.reseniapersona;

import com.example.securityscaffolding.dto.ReseniaPersonaDTO;
import com.example.securityscaffolding.model.entity.ReseniaPersona;
import com.example.securityscaffolding.security.service.ReseniaPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/reseniapersona")
public class ReseniaPersonaController {

    @Autowired
    private ReseniaPersonaService reseniaPersonaService;

    //Lista reseñas
    @GetMapping
    public List<ReseniaPersonaDTO> listaReseniaPersona(){
        return reseniaPersonaService.listaReseniaPersona();
    }

    //Lista reseñas usuario
    @GetMapping("/usuario/{id}")
    public List<ReseniaPersonaDTO> listaReseniaPersonaUsuario(@PathVariable Long id){
        return reseniaPersonaService.listaReseniaPersonaUsuario(id);
    }

    //Subir reseña
    @PostMapping
    public ReseniaPersonaDTO subirReseniaPersona(@RequestBody ReseniaPersona reseniaPersona){
        return reseniaPersonaService.subirReseniaPersona(reseniaPersona);
    }

}
