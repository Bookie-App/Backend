package com.example.securityscaffolding.controller.intercambios;

import com.example.securityscaffolding.dto.IntercambiosDTO;
import com.example.securityscaffolding.model.entity.LibrosPrestados;
import com.example.securityscaffolding.security.service.IntercambiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Esta clase define el controlador para obtener y listar los intercambios de libros en el servidor
 *
 * @author Iñigo Acosta
 * @version 28/04/2024
 * @since 28/04/2024
 */

@CrossOrigin
@RestController
@RequestMapping("api/intercambios")
public class IntercambiosController {

    @Autowired
    private IntercambiosService intercambiosService;

    /**
     * Obtiene todos los intercambios de la base de datos
     *
     * @return una lista DTO de Intercambios
     * @see IntercambiosDTO
     */
    @GetMapping
    public List<IntercambiosDTO> listaIntercambios(){
        return intercambiosService.listaIntercambios();
    }

    /**
     * Obtiene una lista DTO de los intercambios de libros del usuario
     *
     * @param id del usuario
     * @return una lista DTO de Intercambios
     * @see IntercambiosDTO
     */
    @GetMapping("/usuario/{id}")
    public List<IntercambiosDTO> listaIntercambiosUsuario(@PathVariable Long id){
        return intercambiosService.listaIntercambiosUsuario(id);
    }

    /**
     * Crea un intercambio de libros en el servidor
     *
     * @param librosPrestados una entidad de LibrosPrestados
     * @return un DTO de Intercambios
     * @see IntercambiosDTO
     * @see LibrosPrestados
     */
    @PostMapping
    public IntercambiosDTO postIntercambio(@RequestBody LibrosPrestados librosPrestados){
        return intercambiosService.postIntercambio(librosPrestados);
    }
}
