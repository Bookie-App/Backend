package com.example.securityscaffolding.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "libros_prestados")
public class LibrosPrestados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestado;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date fechaPrestado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_libro", referencedColumnName = "idLibro")
    private Libro libro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_emisor", referencedColumnName = "id")
    private Usuario usuarioEmisor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario_receptor", referencedColumnName = "id")
    private Usuario usuarioReceptor;
}
