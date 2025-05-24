package org.example.helloeventsapp.Controller;

import org.example.helloeventsapp.Dto.RegisterRequest;
import org.example.helloeventsapp.Dto.LoginRequest;
import org.example.helloeventsapp.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterRequest request) {
        try {
            String jwt = authService.register(request);
            return ResponseEntity.ok("Inscription réussie. Token: " + jwt);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body("Erreur d'inscription: " + e.getMessage());
        }
    }


}

