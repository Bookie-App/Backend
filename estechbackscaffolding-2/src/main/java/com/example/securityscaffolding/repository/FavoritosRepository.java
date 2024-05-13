package com.example.securityscaffolding.repository;

import com.example.securityscaffolding.model.entity.Favoritos;
import com.example.securityscaffolding.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritosRepository extends JpaRepository<Favoritos,Long> {

    List<Favoritos> findByUsuario(Usuario usuario);
}
