package com.example.securityscaffolding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    private String password;
    private Boolean reportado;
}
