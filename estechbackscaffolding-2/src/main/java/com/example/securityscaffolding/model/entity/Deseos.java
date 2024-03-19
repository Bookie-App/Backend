package com.example.securityscaffolding.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "deseos")
public class Deseos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDeseos;

    private String titulo;

    private String imagen;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "deseos")
    private List<Usuario> usuarios = new ArrayList<>();
}
