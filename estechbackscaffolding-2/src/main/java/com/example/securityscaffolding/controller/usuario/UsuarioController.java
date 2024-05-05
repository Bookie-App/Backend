package com.example.securityscaffolding.controller.usuario;

import com.example.securityscaffolding.dto.UsuarioDTO;
import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Usuario usuario = usuarioService.buscarUsuario(id);
        usuarioService.eliminarUsuario(usuario);
    }

    @GetMapping("/{id}")
    public UsuarioDTO obtenerUsuario(@PathVariable Long id){
        return usuarioService.buscarUsuarioDTO(id);
    }

    @GetMapping
    public List<UsuarioDTO> listaUsuarios(){
        return usuarioService.listaUsuarios();
    }
}
