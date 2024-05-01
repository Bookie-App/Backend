package com.example.securityscaffolding.security.service;

import com.example.securityscaffolding.converter.ChatConverter;
import com.example.securityscaffolding.dto.ChatDTO;
import com.example.securityscaffolding.model.entity.Chats;
import com.example.securityscaffolding.model.entity.Mensaje;
import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.repository.ChatRepository;
import com.example.securityscaffolding.repository.UsuarioRepository;
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

    @Autowired
    private ChatConverter chatConverter;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Map<String, Object>> showById(Long id) {
        Chats chat = chatRepository.findById(id).orElse(null);

        List<Map<String, Object>> listaMapa = new ArrayList<>();

        if (chat != null) {
            List<Mensaje> mensajes = chat.getMensajes();

            mensajes.forEach(mensaje -> {
                Map<String, Object> mapa = new HashMap<>();
                mapa.put("user", mensaje.getUsuario().getId());
                mapa.put("message", mensaje.getTexto());
                mapa.put("fecha", mensaje.getFechaMensaje());
                listaMapa.add(mapa);
            });
        }

        return listaMapa;
    }

    //Subir chat
    public ChatDTO subirChatDTO(Chats chats){
        Chats chatGuardado = chatRepository.save(chats);
        ChatDTO chatDTO = chatConverter.convertChatsToChatDTO(chatGuardado);
        return chatDTO;
    }

    //Lista chats del usuario
    public List<ChatDTO> listaChatsUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        List<Chats> listaChats = chatRepository.findByUsuarioEmisor(usuario);
        List<Chats> listaChats2 = chatRepository.findByUsuarioReceptor(usuario);
        List<ChatDTO> listaDTO = new ArrayList<>();
        listaChats.forEach(chats -> {
            listaDTO.add(chatConverter.convertChatsToChatDTO(chats));
        });
        listaChats2.forEach(chats -> {
            listaDTO.add(chatConverter.convertChatsToChatDTO(chats));
        });
        return listaDTO;
    }
}