package com.example.securityscaffolding.converter;

import com.example.securityscaffolding.dto.UsuarioDTO;
import com.example.securityscaffolding.model.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {

    public UsuarioDTO convertUsuarioToUsuarioDTO(Usuario usuario){
        return UsuarioDTO.builder()
                .nombre(usuario.getNombre())
                .username(usuario.getUsername())
                .email(usuario.getEmail())
                .ciudad(usuario.getCiudad())
                .provincia(usuario.getProvincia())
                .codigoPostal(usuario.getCodigoPostal())
                .foto(usuario.getFoto())
                .bookieFavoritaId(usuario.getBookieFavoritaId())
                .build();
    }
}
