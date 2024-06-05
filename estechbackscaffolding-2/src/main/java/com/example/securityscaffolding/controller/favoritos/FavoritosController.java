package com.example.securityscaffolding.controller.favoritos;

import com.example.securityscaffolding.dto.FavoritosDTO;
import com.example.securityscaffolding.model.entity.Favoritos;
import com.example.securityscaffolding.security.service.FavoritosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Esta clase define el controlador para obtener, eliminar y subir favoritos de libros en la base de datos
 *
 * @author Iñigo Acosta
 * @version 17/05/2024
 * @since 01/05/2024
 */

@CrossOrigin
@RestController
@RequestMapping("api/favoritos")
public class FavoritosController {

    @Autowired
    private FavoritosService favoritosService;

    /**
     * Obtiene todos los favoritos de la base de datos
     *
     * @return una lista DTO de favoritos
     * @see FavoritosDTO
     */
    @GetMapping
    public List<FavoritosDTO> listaFavoritos(){
        return favoritosService.listaFavoritos();
    }

    /**
     * Obtiene los favoritos del usuario
     *
     * @param id del usuario
     * @return una lista DTO con los favoritos del usuario
     * @see FavoritosDTO
     */
    @GetMapping("/usuario/{id}")
    public List<FavoritosDTO> listaFavoritosUsuario(@PathVariable Long id){
        return favoritosService.listaFavoritosUsuario(id);
    }

    /**
     * Crea un favorito del libro en la base de datos
     *
     * @param favoritos una entidad de favoritos
     * @return un DTO de favoritos
     * @see FavoritosDTO
     * @see Favoritos
     */
    @PostMapping
    public FavoritosDTO subirFavorito(@RequestBody Favoritos favoritos){
        return favoritosService.subirFavorito(favoritos);
    }

    /**
     * Elimina el favorito de la base de datos
     *
     * @param id del favorito
     */
    @DeleteMapping("/{id}")
    public void eliminarFavorito(@PathVariable Long id){
        favoritosService.eliminarFavorito(id);
    }
}
