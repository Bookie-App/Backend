package com.example.securityscaffolding.converter;

import com.example.securityscaffolding.dto.ChatDTO;
import com.example.securityscaffolding.model.entity.Chats;
import org.springframework.stereotype.Component;

@Component
public class ChatConverter {

    public ChatDTO convertChatsToChatDTO(Chats chats){
        return ChatDTO.builder()
                .chatId(chats.getId())
                .usuarioReceptorUsername(chats.getUsuarioReceptor().getUsername())
                .usuarioReceptorId(chats.getUsuarioReceptor().getId())
                .usuarioEmisorId(chats.getUsuarioEmisor().getId())
                .usuarioEmisorUsername(chats.getUsuarioEmisor().getUsername())
                .build();
    }
}
