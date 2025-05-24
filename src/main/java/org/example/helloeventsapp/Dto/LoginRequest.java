package org.example.helloeventsapp.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class LoginRequest {

    @NotBlank(message = "Email ne peut pas être vide")
    @Email(message = "Format d'email invalide")
    private String email;

    @NotBlank(message = "Mot de passe ne peut pas être vide")
    private String password;

    // getters et setters

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
