package com.example.securityscaffolding.controller.deseos;

import com.example.securityscaffolding.dto.DeseosDTO;
import com.example.securityscaffolding.model.entity.Deseos;
import com.example.securityscaffolding.security.service.DeseosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Esta clase define el controlador para obtener y subir deseos de libros en la base de datos
 *
 * @author Iñigo Acosta
 * @version 13/05/2024
 * @since 13/05/2024
 */

@CrossOrigin
@RestController
@RequestMapping("api/deseos")
public class DeseosController {

    @Autowired
    private DeseosService deseosService;

    /**
     * Obtiene todos los deseos de la base de datos
     *
     * @return una lista DTO de deseos
     * @see DeseosDTO
     */
    @GetMapping
    public List<DeseosDTO> listaDeseos(){
        return deseosService.listaDeseos();
    }

    /**
     * Obtiene los deseos de libros del usuario
     *
     * @param id del usuario
     * @return una lista DTO de deseos
     * @see DeseosDTO
     */
    @GetMapping("/usuario/{id}")
    public List<DeseosDTO> listaDeseosUsuario(@PathVariable Long id){
        return deseosService.listaDeseosUsuario(id);
    }

    /**
     * Crea un deseo en la base de datos
     *
     * @param deseos una entidad de Deseos
     * @return un DTO de deseos
     * @see DeseosDTO
     * @see Deseos
     */
    @PostMapping
    public DeseosDTO postDeseo(@RequestBody Deseos deseos){
        return deseosService.postDeseo(deseos);
    }
}
