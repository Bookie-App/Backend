package com.example.securityscaffolding.controller.chat;

import com.example.securityscaffolding.dto.ChatDTO;
import com.example.securityscaffolding.model.entity.Chats;
import com.example.securityscaffolding.security.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/{id}")
    public List<Map<String,Object>> chats(@PathVariable Long id){
        return chatService.showById(id);
    }

    @PostMapping
    public ChatDTO subirChatDTO(@RequestBody Chats chats){
        return chatService.subirChatDTO(chats);
    }

    @GetMapping("/usuario/{id}")
    public List<ChatDTO> listaChatsUsuario(@PathVariable Long id){
        return chatService.listaChatsUsuario(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarChat(@PathVariable Long id){
        chatService.eliminarChat(id);
    }
}
