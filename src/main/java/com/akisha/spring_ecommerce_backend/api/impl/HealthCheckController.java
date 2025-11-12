package com.akisha.spring_ecommerce_backend.api.impl;

import com.akisha.spring_ecommerce_backend.api.HealthCheckApi;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController implements HealthCheckApi {

    @Override
    public ResponseEntity<String> getWorkingStatus() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        OAuth2AuthenticatedPrincipal principal = (OAuth2AuthenticatedPrincipal) auth.getPrincipal();

        String username = principal.getAttribute("login");
        return ResponseEntity.ok("Hello " + username + ", It's working");
    }

}
