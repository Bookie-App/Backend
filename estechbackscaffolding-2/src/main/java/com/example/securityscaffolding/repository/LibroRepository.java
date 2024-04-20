package com.example.securityscaffolding.repository;

import com.example.securityscaffolding.model.entity.Libro;
import com.example.securityscaffolding.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {

    List<Libro> findByUsuario(Usuario usuario);
}
