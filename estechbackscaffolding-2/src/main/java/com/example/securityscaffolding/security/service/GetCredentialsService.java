package com.example.securityscaffolding.security.service;

import com.example.securityscaffolding.model.entity.Usuario;
import com.example.securityscaffolding.repository.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GetCredentialsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwtService jwtService;

    public Map<String,Object> getUserFromRequest(HttpServletRequest request, Map<String,Object> map){
        String authHeader = request.getHeader("Authorization");
        String jwt;
        String userAuth;

        jwt = authHeader.substring(7); // contamos 7 caracteres en "Bearer "(incluye el espacio en blanco)
        userAuth = jwtService.extractUsername(jwt);

        Usuario usuario =  usuarioRepository.findByUsername(userAuth).get();
        Long userId = usuario.getId();

        map.put("username" , userAuth);
        map.put("id" , userId);

        return  map;



    }


}
