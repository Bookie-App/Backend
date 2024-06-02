package com.example.securityscaffolding.dto;

import com.example.securityscaffolding.model.enums.Rol;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterRequest {

    private Rol rol;
    private String nombre;
    private String username;
    private String password;
    private String email;
    private String ciudad;
    private String provincia;
    private Integer codigoPostal;
    private String foto;
    private Boolean reportado;
    private String token;
    private Integer bookieFavoritaId;
}
