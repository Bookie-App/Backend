package com.example.securityscaffolding.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AuthenticationResponse {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String token;
    private String username;
}
