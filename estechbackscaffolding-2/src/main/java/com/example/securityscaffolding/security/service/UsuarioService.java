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
import org.springframework.security.crypto.password.PasswordEncoder;
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

    @Autowired
    private PasswordEncoder passwordEncoder;

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

    //Actualizar
    public UsuarioDTO actualizarUsuario(Long id, Usuario usuario){
        Usuario usuario1 = usuarioRepository.findById(id).orElse(null);

        usuario1.setNombre(usuario.getNombre());
        usuario1.setUsername(usuario.getUsername());
        usuario1.setEmail(usuario.getEmail());
        usuario1.setCiudad(usuario.getCiudad());
        usuario1.setProvincia(usuario.getProvincia());
        usuario1.setCodigoPostal(usuario.getCodigoPostal());
        usuario1.setFoto(usuario.getFoto());
        usuario1.setBookieFavoritaId(usuario.getBookieFavoritaId());

        if((usuario1.getNombre().isEmpty() || usuario1.getUsername().isEmpty() || usuario1.getEmail().isEmpty() || usuario1.getCiudad().isEmpty() || usuario1.getProvincia().isEmpty() || usuario1.getCodigoPostal().toString().isEmpty() || usuario1.getFoto().isEmpty() || usuario1.getBookieFavoritaId().toString().isEmpty())){
            return null;
        }else{
            usuarioRepository.save(usuario1);

            UsuarioDTO usuarioDTO = usuarioConverter.convertUsuarioToUsuarioDTO(usuario1);
            return usuarioDTO;
        }
    }

    //Actualizar reportado
    public UsuarioDTO actualizarUsuarioReportado(Long id, Usuario usuario){
        Usuario usuario1 = usuarioRepository.findById(id).orElse(null);

        usuario1.setReportado(usuario.getReportado());

        usuarioRepository.save(usuario1);

        UsuarioDTO usuarioDTO = usuarioConverter.convertUsuarioToUsuarioDTO(usuario1);
        return usuarioDTO;
    }

    public UsuarioDTO actualizarUsuarioPassword(Long id, Usuario usuario){
        Usuario usuario1 = usuarioRepository.findById(id).orElse(null);

        usuario1.setPassword(passwordEncoder.encode(usuario.getPassword()));

        usuarioRepository.save(usuario1);

        UsuarioDTO usuarioDTO = usuarioConverter.convertUsuarioToUsuarioDTO(usuario1);
        return usuarioDTO;
    }
}
