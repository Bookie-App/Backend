package com.example.securityscaffolding.security.service;

import com.example.securityscaffolding.converter.FavoritosConverter;
import com.example.securityscaffolding.dto.FavoritosDTO;
import com.example.securityscaffolding.model.entity.Favoritos;
import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.repository.FavoritosRepository;
import com.example.securityscaffolding.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavoritosService {

    @Autowired
    private FavoritosRepository favoritosRepository;

    @Autowired
    private FavoritosConverter favoritosConverter;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //POST favorito
    public FavoritosDTO subirFavorito(Favoritos favoritos){
        Favoritos favoritoGuardado = favoritosRepository.save(favoritos);
        FavoritosDTO favoritosDTO = favoritosConverter.convertFavoritosToFavoritosDTO(favoritoGuardado);
        return favoritosDTO;
    }

    //Lista todos los favoritos
    public List<FavoritosDTO> listaFavoritos(){
        List<Favoritos> listaFavoritos = favoritosRepository.findAll();
        List<FavoritosDTO> listaDTO = new ArrayList<>();
        listaFavoritos.forEach(favoritos -> {
            listaDTO.add(favoritosConverter.convertFavoritosToFavoritosDTO(favoritos));
        });
        return listaDTO;
    }

    //Lista favoritos del usuario
    public List<FavoritosDTO> listaFavoritosUsuario(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        List<Favoritos> listaFavoritos = favoritosRepository.findByUsuario(usuario);
        List<FavoritosDTO> listaDTO = new ArrayList<>();
        listaFavoritos.forEach(favoritos -> {
            listaDTO.add(favoritosConverter.convertFavoritosToFavoritosDTO(favoritos));
        });
        return listaDTO;
    }

    //Eliminar
    public void eliminarFavorito(Long id){
        favoritosRepository.deleteById(id);
    }
}
