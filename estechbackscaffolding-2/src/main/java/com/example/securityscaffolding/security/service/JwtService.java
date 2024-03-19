package com.example.securityscaffolding.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    // LOS CLAIMS HACEN REFERENCIA A AQUELLOS DATOS QUE YO QUIERO ENVIAR ENCRIPTADOS EN EL TOKEN
    // EL SUBJECT ES UN TIPO DE CLAIM QUE TIENE QUE VER CON EL USUARIO QUE GENERA EL TOKEN, ES DECIR EL USUARIO AUTENTICADO

    private static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";
    private static final Logger logger = LoggerFactory.getLogger(JwtService.class);

    public String generateToken(UserDetails userDetails){
        return generateAccessToken(new HashMap<>(), userDetails);
    }

    // Este método verifica que el token sea válido para ello verifica si el token que tiene es el que yo le he enviado y , además, si no está caducado
    public Boolean isTokenValid(String token , UserDetails userDetails){

        String username = extractUsername(token);

        logger.info("El usuario del token en el método isTokenValid es  " + username);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    public  String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public  <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims); // el método apply coge el primer claim de un conjunto de claims
    }

    public String generateAccessToken(Map<String,Object> extraClaims, UserDetails userDetails){
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // El token expira en un día (86400000 milisegundos)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }


    private Claims extractAllClaims(String token){
        return Jwts
                .parser()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();

    }

    private Key getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY); // Convierto a base 64 para obtener los datos en código máquina
        return Keys.hmacShaKeyFor(keyBytes); // Algoritmo de encriptación
    }
}
