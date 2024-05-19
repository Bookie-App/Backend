package com.example.securityscaffolding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReseniaLibroDTO {

    private Integer puntuacion;
    private String username;
    private String comentario;
    private String fechaReseniaLibro;
    private String libroTitulo;
    private String libroAutor;
    private byte[] libroFoto;
    private Long libroId;
    private String usernameLibro;

}
