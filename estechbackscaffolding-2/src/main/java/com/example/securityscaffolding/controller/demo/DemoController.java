package com.example.securityscaffolding.controller.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @GetMapping
    public ResponseEntity<String> saludar(){

        return ResponseEntity.ok("Hola desde el demo controller");
    }


    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Map<String,Object>> forAdmin(){

        Map<String, Object> mapa = new HashMap<>();
        mapa.put("success" , "Hola admin !");

        return  new ResponseEntity<>(mapa, HttpStatus.OK);
    }


    @GetMapping("/user")
    //@PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public ResponseEntity<Map<String,Object>> forUser(){

        Map<String, Object> mapa = new HashMap<>();
        mapa.put("success" , "Hola user !");

        return  new ResponseEntity<>(mapa , HttpStatus.OK);
    }

}
