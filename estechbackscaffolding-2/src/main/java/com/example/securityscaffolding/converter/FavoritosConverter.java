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
                .tituloLibro(favoritos.getLibro().getTitulo())
                .autorLibro(favoritos.getLibro().getAutor())
                .numeroPaginasLibro(favoritos.getLibro().getNumeroPaginas())
                .generoLibro(favoritos.getLibro().getGenero())
                .fotoLibro(favoritos.getLibro().getFoto())
                .sinopsisLibro(favoritos.getLibro().getSinopsis())
                .editorialLibro(favoritos.getLibro().getEditorial())
                .prestadoLibro(favoritos.getLibro().getPrestado())
                .filtroLibro(favoritos.getLibro().getFiltro())
                .usuarioIdLibro(favoritos.getLibro().getUsuario().getId())
                .usuarioUsernameLibro(favoritos.getLibro().getUsuario().getUsername())
                .build();
    }
}
