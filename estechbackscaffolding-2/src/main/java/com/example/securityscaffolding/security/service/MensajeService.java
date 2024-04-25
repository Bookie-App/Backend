package com.example.securityscaffolding.security.service;

import com.example.securityscaffolding.converter.MensajeConverter;
import com.example.securityscaffolding.dto.MensajeDTO;
import com.example.securityscaffolding.model.entity.Mensaje;
import com.example.securityscaffolding.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    @Autowired
    private MensajeConverter mensajeConverter;

    public MensajeDTO subirMensajeDTO(Mensaje mensaje){
        Mensaje mensajeGuardado = mensajeRepository.save(mensaje);
        MensajeDTO mensajeDTO = mensajeConverter.convertMensajeToMensajeDTO(mensajeGuardado);
        return mensajeDTO;
    }
}
