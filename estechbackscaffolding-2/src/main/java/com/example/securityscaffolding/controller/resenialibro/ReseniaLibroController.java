package com.example.securityscaffolding.controller.resenialibro;

import com.example.securityscaffolding.dto.ReseniaLibroDTO;
import com.example.securityscaffolding.model.entity.ReseniaLibro;
import com.example.securityscaffolding.security.service.ReseniaLibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/resenialibro")
public class ReseniaLibroController {

    @Autowired
    private ReseniaLibroService reseniaLibroService;


    @GetMapping
    public List<ReseniaLibroDTO> listaReseniaLibro(){
        return reseniaLibroService.listaReseniaLibro();
    }

    @GetMapping("/usuario/{id}")
    public List<ReseniaLibroDTO> listaReseniaLibroUsuario(@PathVariable Long id){
        return reseniaLibroService.listaReseniaLibroUsuario(id);
    }

    @PostMapping
    public ReseniaLibroDTO subirReseniaLibro(@RequestBody ReseniaLibro reseniaLibro){
        return reseniaLibroService.subirReseniaLibro(reseniaLibro);
    }
}
