package com.example.securityscaffolding.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "chats")
public class Chats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChat;
    @OneToOne(fetch = FetchType.LAZY)
    private Usuario usuarioEmisor;
    @OneToOne(fetch = FetchType.LAZY)
    private Usuario usuarioReceptor;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "chat")
    private List<Mensaje> mensajes;



   /* @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaEnvio;*/
}
