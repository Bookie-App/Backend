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
@Table(name = "peticiones")
public class Peticiones {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPeticiones;

    private Boolean aceptado;

    private String texto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_emisor", referencedColumnName = "id")
    private Usuario usuarioEmisor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_receptor", referencedColumnName = "id")
    private Usuario usuarioReceptor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro_pedido", referencedColumnName = "idLibro")
    private Libro libro;
}
