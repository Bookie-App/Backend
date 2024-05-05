package com.example.securityscaffolding.converter;

import com.example.securityscaffolding.dto.ReseniaPersonaDTO;
import com.example.securityscaffolding.model.entity.ReseniaPersona;
import org.springframework.stereotype.Component;

@Component
public class ReseniaPersonaConverter {

    public ReseniaPersonaDTO convertReseniaPersonaToReseniaPersonaDTO(ReseniaPersona reseniaPersona){
        return ReseniaPersonaDTO.builder()
                .puntuacion(reseniaPersona.getPuntuacion())
                .username(reseniaPersona.getUsuarioPuntuado().getUsername())
                .comentario(reseniaPersona.getComentario())
                .fechaReseniaPersona(reseniaPersona.getFechaReseniaPersona())
                .build();
    }
}
