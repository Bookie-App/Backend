package com.example.securityscaffolding.controller.mensaje;

import com.example.securityscaffolding.dto.MensajeDTO;
import com.example.securityscaffolding.model.entity.Mensaje;
import com.example.securityscaffolding.security.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mensaje")
public class MensajeController {

    @Autowired
    private MensajeService mensajeService;

    @PostMapping
    public MensajeDTO subirMensajeDTO(@RequestBody Mensaje mensaje){
        return mensajeService.subirMensajeDTO(mensaje);
    }
}
