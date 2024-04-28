package com.example.securityscaffolding.repository;

import com.example.securityscaffolding.model.entity.LibrosPrestados;
import com.example.securityscaffolding.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IntercambiosRepository extends JpaRepository<LibrosPrestados, Long> {

    List<LibrosPrestados> findByUsuarioEmisor(Usuario usuario);

    List<LibrosPrestados> findByUsuarioReceptor(Usuario usuario);
}
