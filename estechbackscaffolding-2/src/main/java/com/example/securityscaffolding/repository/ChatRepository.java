package com.example.securityscaffolding.repository;

import com.example.securityscaffolding.model.entity.Chats;
import com.example.securityscaffolding.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatRepository extends JpaRepository<Chats, Long> {

    List<Chats> findByUsuarioEmisorOrUsuarioReceptor(Usuario usuarioEmisor, Usuario usuarioReceptor);

    List<Chats> findByUsuarioEmisor(Usuario usuarioEmisor);
}
