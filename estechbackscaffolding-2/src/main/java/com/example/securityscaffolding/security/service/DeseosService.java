package com.example.securityscaffolding.security.service;

import com.example.securityscaffolding.converter.DeseosConverter;
import com.example.securityscaffolding.dto.DeseosDTO;
import com.example.securityscaffolding.model.entity.Deseos;
import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.repository.DeseosRepository;
import com.example.securityscaffolding.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeseosService {

    @Autowired
    private DeseosRepository deseosRepository;

    @Autowired
    private DeseosConverter deseosConverter;

    @Autowired
    private UsuarioRepository usuarioRepository;


    public DeseosDTO postDeseo(Deseos deseos){
        Deseos deseoGuardado = deseosRepository.save(deseos);
        DeseosDTO deseosDTO = deseosConverter.convertDeseosToDeseosDTO(deseoGuardado);
        return deseosDTO;
    }

    public List<DeseosDTO> listaDeseos(){
        List<Deseos> deseosList = deseosRepository.findAll();
        List<DeseosDTO> listaDTO = new ArrayList<>();
        deseosList.forEach(deseos -> {
            listaDTO.add(deseosConverter.convertDeseosToDeseosDTO(deseos));
        });
        return listaDTO;
    }

    public List<DeseosDTO> listaDeseosUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        List<Deseos> deseosList = deseosRepository.findByUsuario(usuario);
        List<DeseosDTO> listaDTO = new ArrayList<>();
        deseosList.forEach(deseos -> {
            listaDTO.add(deseosConverter.convertDeseosToDeseosDTO(deseos));
        });
        return listaDTO;
    }
}
