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
        return libroConverter.convertLibroToLibroDTO(libroGuardado);
    }

    //Lista todos los libros
    public List<LibroDTO> listaLibros(){
        List<Libro> listaLibros = libroRepository.findAll();
        List<LibroDTO> listaDTO = new ArrayList<>();
        listaLibros.forEach(libro -> {
            listaDTO.add(libroConverter.convertLibroToLibroDTO(libro));
        });
        return listaDTO;
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

    //Lista libros por género
    public List<LibroDTO> listaLibrosGenero(String genero){
        List<Libro> listaLibros = libroRepository.findByGenero(genero);
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

    //Actualizar
    public LibroDTO actualizarLibro(Long id, Libro libro){
        Libro libro1 = libroRepository.findById(id).orElse(null);

        assert libro1 != null;
        libro1.setTitulo(libro.getTitulo());
        libro1.setAutor(libro.getAutor());
        libro1.setNumeroPaginas(libro.getNumeroPaginas());
        libro1.setGenero(libro.getGenero());
        libro1.setFoto(libro.getFoto());
        libro1.setSinopsis(libro.getSinopsis());
        libro1.setEditorial(libro.getEditorial());


        libroRepository.save(libro1);

        return libroConverter.convertLibroToLibroDTO(libro1);
    }

    //Libro por id
    public LibroDTO buscarLibroDTO(Long id){
        Libro libro = libroRepository.findById(id).orElse(null);
        assert libro != null;
        return libroConverter.convertLibroToLibroDTO(libro);
    }

    //Actualizar libro prestado
    public LibroDTO actualizarLibroPrestado(Long id, Libro libro){
        Libro libro1 = libroRepository.findById(id).orElse(null);

        assert libro1 != null;
        libro1.setPrestado(libro.getPrestado());

        libroRepository.save(libro1);

        return libroConverter.convertLibroToLibroDTO(libro1);
    }

}
