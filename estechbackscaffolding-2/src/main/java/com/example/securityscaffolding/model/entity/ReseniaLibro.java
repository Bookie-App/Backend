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
@Table(name = "resenia_libro")
public class ReseniaLibro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idResLibro;

    private Integer puntuacion;

    private String username;

    private String comentario;

    private String fechaReseniaLibro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_puntuador", referencedColumnName = "id")
    private Usuario usuarioPuntuador;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro", referencedColumnName = "idLibro")
    private Libro libro;
}
