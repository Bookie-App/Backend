package com.example.securityscaffolding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsuarioDTO {

    private String nombre;
    private String username;
    private String email;
    private String ciudad;
    private String provincia;
    private Integer codigoPostal;
    private String foto;
    private Integer bookieFavoritaId;
}
