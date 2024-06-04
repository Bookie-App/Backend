package com.example.securityscaffolding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FavoritosDTO {

    private String titulo;
    private String imagen;
    private String autor;
    private Integer numeroPaginas;
    private String genero;
    private String sinopsis;
    private String editorial;
    private Boolean prestado;
    private Integer libroId;
    private Long libroId2;
    private Long idFavorito;
}
