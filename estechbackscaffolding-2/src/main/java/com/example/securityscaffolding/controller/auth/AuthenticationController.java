package com.example.securityscaffolding.controller.auth;

import com.example.securityscaffolding.dto.AuthenticationRequest;
import com.example.securityscaffolding.dto.AuthenticationResponse;
import com.example.securityscaffolding.dto.RegisterRequest;
import com.example.securityscaffolding.security.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * Esta clase define el controlador que contiene los métodos necesarios para registrar y autenticar un usuario en el servidor.
 *
 * @author Iñigo Acosta
 * @version 03/06/2024
 * @since 19/03/2024
 */

@CrossOrigin
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    /**
     * Para registrar un usuario en el servidor. Devuelve el token del usuario si este no existe en
     * la base de datos. En caso contrario, devuelve null.
     *
     * @param request un DTO con la información del usuario
     * @return el token jwt del usuario
     * @see AuthenticationResponse
     * @see RegisterRequest
     */
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){

        return  ResponseEntity.ok(authenticationService.register(request));
    }

    /**
     * Para autenticar un usuario en el servidor. Este debe estar previamente creado en la base de
     * datos. En caso contrario devuelve un error 401.
     * El método crea unos headers para introducir en estos el token jwt del usuario y no
     * mostrarlo en la respuesta de la petición.
     *
     * @param request un DTO que contiene el username y password del usuario registrado
     * @return el token del usuario en los headers y su username
     * @see AuthenticationResponse
     * @see AuthenticationRequest
     */
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }




}
