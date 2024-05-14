package com.example.securityscaffolding.converter;

import com.example.securityscaffolding.dto.LibroDTO;
import com.example.securityscaffolding.model.entity.Libro;
import org.springframework.stereotype.Component;

@Component
public class LibroConverter {

    public LibroDTO convertLibroToLibroDTO(Libro libro){
        return LibroDTO.builder()
                .autor(libro.getAutor())
                .titulo(libro.getTitulo())
                .numeroPaginas(libro.getNumeroPaginas())
                .foto(libro.getFoto())
                .genero(libro.getGenero())
                .editorial(libro.getEditorial())
                .sinopsis(libro.getSinopsis())
                .usuario(libro.getUsuario().getUsername())
                .userId(libro.getUsuario().getId())
                .libroId(libro.getIdLibro())
                .prestado(libro.getPrestado())
                .filtro(libro.getFiltro())
                .build();

    }
}
