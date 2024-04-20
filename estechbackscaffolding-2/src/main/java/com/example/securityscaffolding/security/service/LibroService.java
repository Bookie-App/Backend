package com.example.securityscaffolding.security.service;

import com.example.securityscaffolding.model.entity.Libro;
import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public Libro subirLibro(Libro libro){
        return libroRepository.save(libro);
    }

    public List<Libro> listaLibros(){
        return libroRepository.findAll();
    }

    public List<Libro> listaLibrosUsuario(Usuario usuario){
        return libroRepository.findByUsuario(usuario);
    }

    public void eliminarLibro(Long id){
        libroRepository.deleteById(id);
    }

}
