package com.example.securityscaffolding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LibroDTO {

    private String titulo;
    private String autor;
    private Integer numeroPaginas;
    private String genero;
    private String foto;
    private String sinopsis;
    private String editorial;
    private Boolean prestado;
    private List<Integer> filtro;
    private String usuario;
    private Long userId;
    private Long libroId;
}
