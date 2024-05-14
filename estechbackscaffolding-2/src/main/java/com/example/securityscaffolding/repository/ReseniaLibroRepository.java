package com.example.securityscaffolding.repository;

import com.example.securityscaffolding.model.entity.ReseniaLibro;
import com.example.securityscaffolding.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReseniaLibroRepository extends JpaRepository<ReseniaLibro, Long> {

    List<ReseniaLibro> findByUsuarioPuntuador(Usuario usuario);
}
