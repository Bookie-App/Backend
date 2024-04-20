package com.example.securityscaffolding.controller.libro;

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
    public List<Libro> listaLibros(){
        return libroService.listaLibros();
    }

    @GetMapping("/usuario")
    public List<Libro> listaLibroUsuario(@RequestBody Usuario usuario){
        return libroService.listaLibrosUsuario(usuario);
    }

    //Subir libro
    @PostMapping
    public Libro subirLibro(@RequestBody Libro libro){
        return libroService.subirLibro(libro);
    }

    //Eliminar libro
    @DeleteMapping
    public void eliminarLibro(Long id){
        libroService.eliminarLibro(id);
    }
}
