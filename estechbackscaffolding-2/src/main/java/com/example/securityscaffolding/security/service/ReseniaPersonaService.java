package com.example.securityscaffolding.security.service;

import com.example.securityscaffolding.converter.ReseniaPersonaConverter;
import com.example.securityscaffolding.dto.ReseniaPersonaDTO;
import com.example.securityscaffolding.model.entity.ReseniaPersona;
import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.repository.ReseniaPersonaRepository;
import com.example.securityscaffolding.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReseniaPersonaService {

    @Autowired
    private ReseniaPersonaRepository reseniaPersonaRepository;

    @Autowired
    private ReseniaPersonaConverter reseniaPersonaConverter;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Subir reseña
    public ReseniaPersonaDTO subirReseniaPersona(ReseniaPersona reseniaPersona){
        ReseniaPersona reseniaGuardada = reseniaPersonaRepository.save(reseniaPersona);
        ReseniaPersonaDTO reseniaPersonaDTO = reseniaPersonaConverter.convertReseniaPersonaToReseniaPersonaDTO(reseniaGuardada);
        return reseniaPersonaDTO;
    }

    //Lista reseñas
    public List<ReseniaPersonaDTO> listaReseniaPersona(){
        List<ReseniaPersona> listaReseniaPersona = reseniaPersonaRepository.findAll();
        List<ReseniaPersonaDTO> listaReseniaPersonaDTO = new ArrayList<>();
        listaReseniaPersona.forEach(reseniaPersona -> {
            listaReseniaPersonaDTO.add(reseniaPersonaConverter.convertReseniaPersonaToReseniaPersonaDTO(reseniaPersona));
        });
        return listaReseniaPersonaDTO;
    }

    //Lista reseñas usuario
    public List<ReseniaPersonaDTO> listaReseniaPersonaUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        List<ReseniaPersona> listaReseniaPersona = reseniaPersonaRepository.findByUsuarioPuntuado(usuario);
        List<ReseniaPersonaDTO> listaDTO = new ArrayList<>();
        listaReseniaPersona.forEach(reseniaPersona -> {
            listaDTO.add(reseniaPersonaConverter.convertReseniaPersonaToReseniaPersonaDTO(reseniaPersona));
        });
        return listaDTO;
    }
}
