package com.example.securityscaffolding.converter;

import com.example.securityscaffolding.dto.ReseniaLibroDTO;
import com.example.securityscaffolding.model.entity.ReseniaLibro;
import org.springframework.stereotype.Component;

@Component
public class ReseniaLibroConverter {

    public ReseniaLibroDTO convertReseniaLibroToReseniaLibroDTO(ReseniaLibro reseniaLibro){
        return ReseniaLibroDTO.builder()
                .puntuacion(reseniaLibro.getPuntuacion())
                .username(reseniaLibro.getUsuarioPuntuador().getUsername())
                .comentario(reseniaLibro.getComentario())
                .fechaReseniaLibro(reseniaLibro.getFechaReseniaLibro())
                .libroTitulo(reseniaLibro.getLibro().getTitulo())
                .libroAutor(reseniaLibro.getLibro().getAutor())
                .libroFoto(reseniaLibro.getLibro().getFoto())
                .libroId(reseniaLibro.getLibro().getIdLibro())
                .usernameLibro(reseniaLibro.getLibro().getUsuario().getUsername())
                .build();
    }
}
