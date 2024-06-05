package com.example.securityscaffolding.controller.credentials;

import com.example.securityscaffolding.security.service.GetCredentialsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * Esta clase define el controlador que contiene el método para obtener los datos del usuario a partir del token jwt.
 *
 * @author Iñigo Acosta
 * @version 19/03/2024
 * @since 19/03/2024
 */

@CrossOrigin
@RestController
@RequestMapping("/api/credentials")
public class GetUserCredentialsController {

    @Autowired
    private GetCredentialsService getCredentialsService;

    /**
     * Se manda una petición con el token jwt del usuario y a partir de este, se obtiene su información
     *
     * @param request una interfaz que contiene métodos para obtener información
     * @param map
     * @return un mapa con clave y valor que cotiene los atributos del usuario
     * @see HttpServletRequest
     */
    @PostMapping("/get-user-from-token")
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public ResponseEntity<Map<String,Object>> getTokenFromRequest(HttpServletRequest request, Map<String,Object> map){
        map = getCredentialsService.getUserFromRequest(request, map);
        return  ResponseEntity.ok(map);
    }

}
