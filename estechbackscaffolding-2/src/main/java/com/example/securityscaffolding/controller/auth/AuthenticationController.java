package com.example.securityscaffolding.controller.auth;

import com.example.securityscaffolding.dto.AuthenticationRequest;
import com.example.securityscaffolding.dto.AuthenticationResponse;
import com.example.securityscaffolding.dto.RegisterRequest;
import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.model.enums.Rol;
import com.example.securityscaffolding.security.service.AuthenticationService;
import com.example.securityscaffolding.security.service.GetCredentialsService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;


    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){

        return  ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        AuthenticationResponse authResponse = authenticationService.authenticate(request);

        // Crear encabezados y añadir el token
        HttpHeaders headers = new HttpHeaders();
        headers.add("Auth-Token", authResponse.getToken());

        // Devolver la respuesta sin el token en el cuerpo
        authResponse.setToken(null); // Opcional: para asegurarte de que no se envíe en el cuerpo

        return new ResponseEntity<>(authResponse, headers, HttpStatus.OK);
    }




}
