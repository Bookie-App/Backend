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

@CrossOrigin
@RestController
@RequestMapping("/api/credentials")
public class GetUserCredentialsController {

    @Autowired
    private GetCredentialsService getCredentialsService;

    @PostMapping("/get-user-from-token")
    @PreAuthorize("hasAnyRole('ROLE_USER' , 'ROLE_ADMIN')")
    public ResponseEntity<Map<String,Object>> getTokenFromRequest(HttpServletRequest request, Map<String,Object> map){
        map = getCredentialsService.getUserFromRequest(request, map);
        return  ResponseEntity.ok(map);
    }

}
