package com.example.securityscaffolding.repository;

import com.example.securityscaffolding.model.entity.Chats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chats, Long> {


}
