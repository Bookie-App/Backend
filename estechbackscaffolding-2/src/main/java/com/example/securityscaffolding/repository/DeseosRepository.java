package com.example.securityscaffolding.repository;

import com.example.securityscaffolding.model.entity.Deseos;
import com.example.securityscaffolding.model.entity.Favoritos;
import com.example.securityscaffolding.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeseosRepository extends JpaRepository<Deseos,Long> {

    List<Deseos> findByUsuario(Usuario usuario);
}
