package com.example.securityscaffolding.security.service;

import com.example.securityscaffolding.converter.UsuarioConverter;
import com.example.securityscaffolding.dto.UsuarioDTO;
import com.example.securityscaffolding.model.entity.Chats;
import com.example.securityscaffolding.model.entity.Mensaje;
import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.repository.ChatRepository;
import com.example.securityscaffolding.repository.MensajeRepository;
import com.example.securityscaffolding.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioConverter usuarioConverter;

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MensajeRepository mensajeRepository;

    public void eliminarUsuario(Usuario usuario) {
        List<Chats> chats =  chatRepository.findByUsuarioEmisorOrUsuarioReceptor(usuario, usuario);
        List<Long> chatsIds = new ArrayList<>();
        List<Mensaje> mensajes = new ArrayList<>();

        chats.forEach(chat -> {
            chat.getMensajes().forEach(mensaje -> {
                mensajes.add((mensaje));
            });
        });

        chats.forEach(chat -> {
            chatsIds.add(chat.getId());
        });

        mensajes.forEach(mensaje -> {
            mensajeRepository.deleteById(mensaje.getId());
        });

        chatsIds.forEach(chatsId ->{
            chatRepository.deleteById(chatsId);
        });

        usuarioRepository.deleteById(usuario.getId());
    }

    public Usuario buscarUsuario(Long id){
        return usuarioRepository.findById(id).orElse(null);

    }

    public UsuarioDTO buscarUsuarioDTO(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        UsuarioDTO usuarioDTO = usuarioConverter.convertUsuarioToUsuarioDTO(usuario);
        return usuarioDTO;
    }

    public List<UsuarioDTO> listaUsuarios(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioDTO> listaDTO = new ArrayList<>();
        usuarios.forEach(usuario -> {
            listaDTO.add(usuarioConverter.convertUsuarioToUsuarioDTO(usuario));
        });
        return listaDTO;
    }
}
