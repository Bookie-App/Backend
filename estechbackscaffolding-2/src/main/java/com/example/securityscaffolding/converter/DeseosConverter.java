package com.example.securityscaffolding.converter;

import com.example.securityscaffolding.dto.DeseosDTO;
import com.example.securityscaffolding.model.entity.Deseos;
import org.springframework.stereotype.Component;

@Component
public class DeseosConverter {

    public DeseosDTO convertDeseosToDeseosDTO(Deseos deseos){
        return DeseosDTO.builder()
                .titulo(deseos.getTitulo())
                .imagen(deseos.getImagen())
                .build();
    }
}
