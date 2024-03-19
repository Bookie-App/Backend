package com.example.securityscaffolding.repository;

import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.model.enums.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario,Long> {
    Optional<Usuario> findByUsername(String username);
}
