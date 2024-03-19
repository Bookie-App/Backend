package com.example.securityscaffolding.security.service;

import com.example.securityscaffolding.model.entity.Chats;
import com.example.securityscaffolding.model.entity.Mensaje;
import com.example.securityscaffolding.repository.ChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;


    public List<Map<String, Object>> showById(Long id) {
        Chats chat = chatRepository.findById(id).orElse(null);

        List<Map<String, Object>> listaMapa = new ArrayList<>();

        if (chat != null) {
            List<Mensaje> mensajes = chat.getMensajes();

            mensajes.forEach(mensaje -> {
                Map<String, Object> mapa = new HashMap<>();
                mapa.put("user", mensaje.getUsuario().getId());
                mapa.put("message", mensaje.getMensaje());
                listaMapa.add(mapa);
            });
        }

        return listaMapa;
    }

}