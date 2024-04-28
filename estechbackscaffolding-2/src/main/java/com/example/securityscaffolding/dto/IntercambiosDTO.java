package com.example.securityscaffolding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class IntercambiosDTO {

    private String libro;
    private String usuarioEmisor;
    private String usuarioReceptor;
    private String fechaPrestado;
}
