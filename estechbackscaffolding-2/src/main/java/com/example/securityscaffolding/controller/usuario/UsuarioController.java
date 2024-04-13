package com.example.securityscaffolding.controller.usuario;

import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
