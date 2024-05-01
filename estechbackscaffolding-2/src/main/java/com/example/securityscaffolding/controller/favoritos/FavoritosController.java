package com.example.securityscaffolding.controller.favoritos;

import com.example.securityscaffolding.dto.FavoritosDTO;
import com.example.securityscaffolding.model.entity.Favoritos;
import com.example.securityscaffolding.security.service.FavoritosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/favoritos")
public class FavoritosController {

    @Autowired
    private FavoritosService favoritosService;

    //Lista favoritos
    @GetMapping
    public List<FavoritosDTO> listaFavoritos(){
        return favoritosService.listaFavoritos();
    }

    //Lista favoritos del usuario
    @GetMapping("/usuario/{id}")
    public List<FavoritosDTO> listaFavoritosUsuario(@PathVariable Long id){
        return favoritosService.listaFavoritosUsuario(id);
    }

    //Subir favorito
    @PostMapping
    public FavoritosDTO subirFavorito(@RequestBody Favoritos favoritos){
        return favoritosService.subirFavorito(favoritos);
    }
}
