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
        String nombre = usuario.getNombre();
        String email = usuario.getEmail();
        String ciudad = usuario.getCiudad();
        String provincia = usuario.getProvincia();
        Integer codigoPostal = usuario.getCodigoPostal();
        String foto = usuario.getFoto();

        map.put("username" , userAuth);
        map.put("id" , userId);
        map.put("nombre", nombre);
        map.put("email", email);
        map.put("ciudad", ciudad);
        map.put("provincia", provincia);
        map.put("codigoPostal", codigoPostal);
        map.put("foto", foto);

        return  map;



    }


}
