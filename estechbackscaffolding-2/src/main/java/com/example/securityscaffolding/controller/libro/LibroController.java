package com.example.securityscaffolding.controller.libro;

import com.example.securityscaffolding.dto.LibroDTO;
import com.example.securityscaffolding.model.entity.Libro;
import com.example.securityscaffolding.security.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Esta clase define el controlador para gestionar todos los datos de los libros en el servidor
 *
 * @author Iñigo Acosta
 * @version 30/05/2024
 * @since 19/03/2024
 */

@CrossOrigin
@RestController
@RequestMapping("api/libro")
public class LibroController {

    @Autowired
    private LibroService libroService;

    /**
     * Obtiene todos los libros de la base de datos
     *
     * @return una lista DTO de libros
     * @see LibroDTO
     */
    @GetMapping
    public List<LibroDTO> listaLibros(){
        return libroService.listaLibros();
    }

    /**
     * Obtiene una lista DTO de los libros que ha subido el usuario en el servidor
     *
     * @param id del usuario
     * @return una lista DTO de los libros del usuario
     * @see LibroDTO
     */
    @GetMapping("/usuario/{id}")
    public List<LibroDTO> listaLibroUsuario(@PathVariable Long id){
        return libroService.listaLibrosUsuario(id);
    }

    /**
     * Obtiene una lista DTO de los libros clasificándolos por género literario
     *
     * @param genero del libro
     * @return una lista DTO de los libros según el género de estos
     * @see LibroDTO
     */
    @GetMapping("/genero/{genero}")
    public List<LibroDTO> listaLibrosGenero(@PathVariable String genero){
        return libroService.listaLibrosGenero(genero);
    }

    /**
     * Crea un libro en la base de datos
     *
     * @param libro
     * @return un DTO de libro
     * @see LibroDTO
     * @see Libro
     */
    @PostMapping
    public LibroDTO subirLibro(@RequestBody Libro libro){
        return libroService.subirLibro(libro);
    }

    /**
     * Elimina un libro de la base de datos
     *
     * @param id del libro
     */
    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id){
        libroService.eliminarLibro(id);
    }

    /**
     * Actualiza el libro en la base de datos
     *
     * @param id del libro
     * @param libro una entidad de libro
     * @return un libro DTO con los datos actualizados
     * @see LibroDTO
     * @see Libro
     */
    @PutMapping("/{id}")
    public LibroDTO actualizarLibro(@PathVariable Long id, @RequestBody Libro libro){
        return libroService.actualizarLibro(id,libro);
    }

    /**
     * Busca el libro por su id en de la base de datos y muestra sus datos
     *
     * @param id del libro
     * @return un libro DTO con sus datos
     * @see LibroDTO
     */
    @GetMapping("/{id}")
    public LibroDTO buscarLibro(@PathVariable Long id){
        return libroService.buscarLibroDTO(id);
    }

    /**
     * Actualiza el libro según este prestado o no. Solo actualiza este campo
     *
     * @param id del libro
     * @param libro una entidad de libro
     * @return un DTO de libro con la variable de prestado actualizada
     * @see LibroDTO
     * @see Libro
     */
    @PutMapping("/prestado/{id}")
    public LibroDTO actualizarLibroPrestado(@PathVariable Long id, @RequestBody Libro libro){
        return libroService.actualizarLibroPrestado(id,libro);
    }
}
