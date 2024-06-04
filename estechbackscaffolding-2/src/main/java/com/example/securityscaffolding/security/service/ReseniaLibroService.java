package com.example.securityscaffolding.security.service;

import com.example.securityscaffolding.converter.ReseniaLibroConverter;
import com.example.securityscaffolding.dto.ReseniaLibroDTO;
import com.example.securityscaffolding.model.entity.ReseniaLibro;
import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.repository.ReseniaLibroRepository;
import com.example.securityscaffolding.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReseniaLibroService {

    @Autowired
    private ReseniaLibroRepository reseniaLibroRepository;

    @Autowired
    private ReseniaLibroConverter reseniaLibroConverter;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ReseniaLibroDTO subirReseniaLibro(ReseniaLibro reseniaLibro){
        ReseniaLibro reseniaLibro1 = reseniaLibroRepository.save(reseniaLibro);
        return reseniaLibroConverter.convertReseniaLibroToReseniaLibroDTO(reseniaLibro1);
    }

    public List<ReseniaLibroDTO> listaReseniaLibro(){
        List<ReseniaLibro> reseniaLibroList = reseniaLibroRepository.findAll();
        List<ReseniaLibroDTO> reseniaLibroDTOS = new ArrayList<>();
        reseniaLibroList.forEach(reseniaLibro -> {
            reseniaLibroDTOS.add(reseniaLibroConverter.convertReseniaLibroToReseniaLibroDTO(reseniaLibro));
        });
        return reseniaLibroDTOS;
    }

    public List<ReseniaLibroDTO> listaReseniaLibroUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        List<ReseniaLibro> reseniaLibros = reseniaLibroRepository.findByUsuarioPuntuador(usuario);
        List<ReseniaLibroDTO> reseniaLibroDTOS = new ArrayList<>();
        reseniaLibros.forEach(reseniaLibro -> {
            reseniaLibroDTOS.add(reseniaLibroConverter.convertReseniaLibroToReseniaLibroDTO(reseniaLibro));
        });
        return reseniaLibroDTOS;
    }
}
