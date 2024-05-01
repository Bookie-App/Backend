package com.example.securityscaffolding.converter;

import com.example.securityscaffolding.dto.MensajeDTO;
import com.example.securityscaffolding.model.entity.Mensaje;
import org.springframework.stereotype.Component;

@Component
public class MensajeConverter {

    public MensajeDTO convertMensajeToMensajeDTO(Mensaje mensaje){
        return MensajeDTO.builder()
                .texto(mensaje.getTexto())
                .userId(mensaje.getUsuario().getId())
                .fechaMensaje(mensaje.getFechaMensaje())
                .build();
    }
}
