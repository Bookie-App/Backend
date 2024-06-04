package com.example.securityscaffolding.controller.chat;

import com.example.securityscaffolding.dto.ChatDTO;
import com.example.securityscaffolding.model.entity.Chats;
import com.example.securityscaffolding.security.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * Esta clase define el controlador que contiene los métodos para gestionar el chat en el servidor.
 *
 * @author Iñigo Acosta
 * @version 31/05/2024
 * @since 19/03/2024
 */

@CrossOrigin
@RestController
@RequestMapping("api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    /**
     * Busca el chat por id en la base de datos. Muestra todos los mensajes intercambiados
     * entre los usuarios del chat.
     *
     * @param id del chat en la BBDD
     * @return un mapa que contiene la lista de mensajes acumulados en el chat.
     */
    @GetMapping("/{id}")
    public List<Map<String,Object>> chats(@PathVariable Long id){
        return chatService.showById(id);
    }

    /**
     * Crea un chat en la base de datos pasandole el id del usuario emisor y el id del usuario receptor
     * del mensaje.
     *
     * @param chats una entidad de Chat que contiene el usuario receptor y emisor
     * @return un DTO de chat que contiene el id del usuario receptor, el del receptor y sus usernames
     * @see ChatDTO
     * @see Chats
     */
    @PostMapping
    public ChatDTO subirChatDTO(@RequestBody Chats chats){
        return chatService.subirChatDTO(chats);
    }

    /**
     * Obtiene los chats activos en los que se encuentra el usuario
     *
     * @param id del usuario
     * @return la lista de chats en los que esta el usuario. Mostrando el id del usuario emisor y receptor y sus usernames
     * @see ChatDTO
     */
    @GetMapping("/usuario/{id}")
    public List<ChatDTO> listaChatsUsuario(@PathVariable Long id){
        return chatService.listaChatsUsuario(id);
    }

    /**
     * Elimina un chat de la base de datos
     *
     * @param id del chat
     */
    @DeleteMapping("/{id}")
    public void eliminarChat(@PathVariable Long id){
        chatService.eliminarChat(id);
    }
}
