package com.example.securityscaffolding.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ChatDTO {

    private Long chatId;
    private Long usuarioEmisorId;
    private Long usuarioReceptorId;
    private String usuarioReceptorUsername;
    private String usuarioEmisorUsername;
}
