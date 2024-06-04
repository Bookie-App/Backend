package com.example.securityscaffolding.security.service;

import com.example.securityscaffolding.converter.IntercambiosConverter;
import com.example.securityscaffolding.dto.IntercambiosDTO;
import com.example.securityscaffolding.model.entity.LibrosPrestados;
import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.repository.IntercambiosRepository;
import com.example.securityscaffolding.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntercambiosService {

    @Autowired
    private IntercambiosRepository intercambiosRepository;

    @Autowired
    private IntercambiosConverter intercambiosConverter;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public IntercambiosDTO postIntercambio(LibrosPrestados librosPrestados){
        LibrosPrestados intercambioGuardado = intercambiosRepository.save(librosPrestados);
        return intercambiosConverter.convertLibrosPrestadosToIntercambiosDTO(intercambioGuardado);
    }

    public List<IntercambiosDTO> listaIntercambios(){
        List<LibrosPrestados> listaLibrosPrestados = intercambiosRepository.findAll();
        List<IntercambiosDTO> listaIntercambiosDTO = new ArrayList<>();
        listaLibrosPrestados.forEach(librosPrestados -> {
            listaIntercambiosDTO.add(intercambiosConverter.convertLibrosPrestadosToIntercambiosDTO(librosPrestados));
        });
        return listaIntercambiosDTO;
    }

    public List<IntercambiosDTO> listaIntercambiosUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        List<LibrosPrestados> listaLibrosPrestados = intercambiosRepository.findByUsuarioEmisor(usuario);
        List<LibrosPrestados> listaLibrosPrestados2 = intercambiosRepository.findByUsuarioReceptor(usuario);
        List<IntercambiosDTO> listaDTO = new ArrayList<>();
        listaLibrosPrestados.forEach(librosPrestados -> {
            listaDTO.add(intercambiosConverter.convertLibrosPrestadosToIntercambiosDTO(librosPrestados));
        });
        listaLibrosPrestados2.forEach(librosPrestados -> {
            listaDTO.add(intercambiosConverter.convertLibrosPrestadosToIntercambiosDTO(librosPrestados));
        });
        return listaDTO;
    }
}
