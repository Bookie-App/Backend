package com.example.securityscaffolding.security.service;

import com.example.securityscaffolding.model.entity.Mensaje;
import com.example.securityscaffolding.repository.MensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    public Mensaje saveMessage(Mensaje mensaje){
        return mensajeRepository.save(mensaje);
    }
}
