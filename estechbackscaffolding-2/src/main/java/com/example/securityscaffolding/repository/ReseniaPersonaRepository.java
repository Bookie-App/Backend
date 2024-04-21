package com.example.securityscaffolding.repository;

import com.example.securityscaffolding.model.entity.ReseniaPersona;
import com.example.securityscaffolding.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReseniaPersonaRepository extends JpaRepository<ReseniaPersona, Long> {

    List<ReseniaPersona> findByUsuarioPuntuador(Usuario usuario);
}
