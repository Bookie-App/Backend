package com.example.securityscaffolding.controller.usuario;

import com.example.securityscaffolding.dto.UsuarioDTO;
import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.security.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @PutMapping("/{id}")
    public UsuarioDTO actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.actualizarUsuario(id,usuario);
    }

    @PutMapping("/reportado/{id}")
    public UsuarioDTO actualizarUsuarioReportado(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.actualizarUsuarioReportado(id,usuario);
    }

    @PutMapping("/password/{id}")
    public UsuarioDTO actualizarUsuarioPassword(@PathVariable Long id, @RequestBody Usuario usuario){
        return usuarioService.actualizarUsuarioPassword(id,usuario);
    }
}
