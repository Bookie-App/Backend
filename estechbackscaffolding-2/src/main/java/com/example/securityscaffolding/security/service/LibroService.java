package com.example.securityscaffolding.security.service;

import com.example.securityscaffolding.converter.LibroConverter;
import com.example.securityscaffolding.dto.LibroDTO;
import com.example.securityscaffolding.model.entity.Libro;
import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.repository.LibroRepository;
import com.example.securityscaffolding.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private LibroConverter libroConverter;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Subir libro
    public LibroDTO subirLibro(Libro libro){
        Libro libroGuardado = libroRepository.save(libro);
        LibroDTO libroDTO = libroConverter.convertLibroToLibroDTO(libroGuardado);
        return libroDTO;
    }

    //Lista libros
    public List<Libro> listaLibros(){
        return libroRepository.findAll();
    }

    //Lista libros usuario
    public List<LibroDTO> listaLibrosUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        List<Libro> listaLibros = libroRepository.findByUsuario(usuario);
        List<LibroDTO> listaDTO = new ArrayList<>();
        listaLibros.forEach(libro -> {
            listaDTO.add(libroConverter.convertLibroToLibroDTO(libro));
        });
        return listaDTO;
    }

    //Eliminar
    public void eliminarLibro(Long id){
        libroRepository.deleteById(id);
    }

}
