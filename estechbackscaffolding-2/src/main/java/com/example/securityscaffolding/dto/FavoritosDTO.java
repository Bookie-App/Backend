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
    private Long libroId;
    private Long idFavorito;
    private String tituloLibro;
    private String autorLibro;
    private Integer numeroPaginasLibro;
    private String generoLibro;
    private String fotoLibro;
    private String sinopsisLibro;
    private String editorialLibro;
    private Boolean prestadoLibro;
    private Set<Integer> filtroLibro;
    private Long usuarioIdLibro;
    private String usuarioUsernameLibro;

}
