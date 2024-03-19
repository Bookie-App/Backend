package com.example.securityscaffolding.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "resenia_persona")
public class ReseniaPersona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResenia;

    private Integer puntuacion;

    private String username;

    private String comentario;

    private String fechaReseniaPersona;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_puntuado", referencedColumnName = "id")
    private Usuario usuarioPuntuado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_puntuador", referencedColumnName = "id")
    private Usuario usuarioPuntuador;
}
