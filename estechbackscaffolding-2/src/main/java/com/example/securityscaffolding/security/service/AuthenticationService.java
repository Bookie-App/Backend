package com.example.securityscaffolding.security.service;

import com.example.securityscaffolding.dto.AuthenticationRequest;
import com.example.securityscaffolding.dto.AuthenticationResponse;
import com.example.securityscaffolding.dto.RegisterRequest;
import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.model.enums.Rol;
import com.example.securityscaffolding.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UserDetailsRepositoryReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        var findUsername = usuarioRepository.findByUsername(request.getUsername());

        if(findUsername.isEmpty()){
            var user = Usuario.builder()
                    .rol(Rol.valueOf(request.getRol()))
                    .nombre(request.getNombre())
                    .username(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .email(request.getEmail())
                    .ciudad(request.getCiudad())
                    .provincia(request.getProvincia())
                    .codigoPostal(request.getCodigoPostal())
                    .foto(request.getFoto())
                    .reportado(request.getReportado())
                    .token(request.getToken())
                    .build();

            usuarioRepository.save(user);
            var jwtToken = jwtService.generateToken(user);

            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }else{
            return null;
        }

    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                  request.getUsername(),
                  request.getPassword()
                )
        );

        var user =  usuarioRepository.findByUsername(request.getUsername())
                .orElseThrow( () -> new UsernameNotFoundException("Usuario no autorizado !!"));

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .username(request.getUsername())
                .build();
    }

}
