package com.example.securityscaffolding.converter;

import com.example.securityscaffolding.dto.FavoritosDTO;
import com.example.securityscaffolding.model.entity.Favoritos;
import org.springframework.stereotype.Component;

@Component
public class FavoritosConverter {

    public FavoritosDTO convertFavoritosToFavoritosDTO(Favoritos favoritos){
        return FavoritosDTO.builder()
                .titulo(favoritos.getTitulo())
                .imagen(favoritos.getImagen())
                .libroId(favoritos.getLibro().getIdLibro())
                .idFavorito(favoritos.getIdFavorito())
                .build();
    }
}
