package org.example.helloeventsapp.Controller;

import org.example.helloeventsapp.Entity.Utilisateur;
import org.example.helloeventsapp.Service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/utilisateurs")
@CrossOrigin(origins = "*")
public class UtilisateurController {

    @Autowired
    private UtilisateurService utilisateurService;

    @GetMapping("/")
    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurService.getAllUtilisateurs();
    }
    @PostMapping("/register")
    public ResponseEntity<?> enregistrerUtilisateur(@RequestBody Utilisateur utilisateur) {

        if (utilisateurService.emailExiste(utilisateur.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body("❌ Email déjà enregistré");
        }

        Utilisateur savedUser = utilisateurService.registerUtilisateur(utilisateur);
        return ResponseEntity.ok(savedUser);
    }
}

