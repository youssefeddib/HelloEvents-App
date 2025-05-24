package org.example.helloeventsapp.Service;

import org.example.helloeventsapp.Dto.RegisterRequest;
import org.example.helloeventsapp.Dto.LoginRequest;
import org.example.helloeventsapp.Entity.Role;
import org.example.helloeventsapp.Entity.Utilisateur;
import org.example.helloeventsapp.Repository.RoleRepository;
import org.example.helloeventsapp.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;


    public String register(RegisterRequest request) {


        if (utilisateurRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email déjà utilisé");
        }

        Optional<Role> roleOpt = roleRepository.findByName(request.getRole());
        if (roleOpt.isEmpty()) {
            throw new RuntimeException("Role invalide");
        }
        Role role = roleOpt.get();

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(request.getEmail());
        utilisateur.setFullName(request.getFullName());

        utilisateur.setPassword(passwordEncoder.encode(request.getPassword()));
        utilisateur.setRole(role);
        utilisateurRepository.save(utilisateur);

        return jwtService.generateToken(utilisateur);
    }


}
