package com.example.securityscaffolding.converter;

import com.example.securityscaffolding.dto.IntercambiosDTO;
import com.example.securityscaffolding.model.entity.LibrosPrestados;
import org.springframework.stereotype.Component;

@Component
public class IntercambiosConverter {

    public IntercambiosDTO convertLibrosPrestadosToIntercambiosDTO(LibrosPrestados librosPrestados){
        return IntercambiosDTO.builder()
                .libro(librosPrestados.getLibro().getTitulo())
                .fechaPrestado(librosPrestados.getFechaPrestado().toString())
                .usuarioEmisor(librosPrestados.getUsuarioEmisor().getUsername())
                .usuarioReceptor(librosPrestados.getUsuarioReceptor().getUsername())
                .build();
    }
}
