package com.example.securityscaffolding.controller.global_exception_handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * Esta clase define un componente para mostrar un mensaje de error de tipo JSON al hacer peticiones
 * 403 al servidor
 *
 * @author Iñigo Acosta
 * @version 26/05/2024
 * @since 26/05/2024
 */

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    /**
     * Este método sobreescrito proveniente de la interfaz AuthenticationEntryPoint se va a encargar
     * de mostrar un mensaje al hacer una petición de tipo 403. Para ello, dentro de la función se
     * maneja el parámetro response que es el encargado de mostrar la respuesta de la petición.
     * Definimos el tipo de respuesta que queremos, en este caso JSON. Especificamos que estatus esperamos
     * y finalmente escribimos el mensaje de error.
     *
     * @param request
     * @param response
     * @param authException
     * @throws IOException
     * @throws ServletException
     * @see HttpServletRequest
     * @see HttpServletResponse
     * @see AuthenticationEntryPoint
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("{ \"error\": \"Unauthorized\", \"message\": \"No estás autenticado para acceder a esta página.\" }");
    }
}


