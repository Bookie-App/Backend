package com.example.securityscaffolding.controller.libro;

import com.example.securityscaffolding.dto.LibroDTO;
import com.example.securityscaffolding.model.entity.Libro;
import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.security.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    //Lista libros
    @GetMapping
    public List<LibroDTO> listaLibros(){
        return libroService.listaLibros();
    }

    //Lista libros usuario
    @GetMapping("/usuario/{id}")
    public List<LibroDTO> listaLibroUsuario(@PathVariable Long id){
        return libroService.listaLibrosUsuario(id);
    }

    //Lista libros por género
    @GetMapping("/genero/{genero}")
    public List<LibroDTO> listaLibrosGenero(@PathVariable String genero){
        return libroService.listaLibrosGenero(genero);
    }

    //Subir libro
    @PostMapping
    public LibroDTO subirLibro(@RequestBody Libro libro){
        return libroService.subirLibro(libro);
    }

    //Eliminar libro
    @DeleteMapping
    public void eliminarLibro(Long id){
        libroService.eliminarLibro(id);
    }
}
