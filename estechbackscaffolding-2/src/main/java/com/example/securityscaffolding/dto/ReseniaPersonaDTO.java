package com.example.securityscaffolding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ReseniaPersonaDTO {

    private Integer puntuacion;
    private String username;
    private String comentario;
    private String fechaReseniaPersona;
}
