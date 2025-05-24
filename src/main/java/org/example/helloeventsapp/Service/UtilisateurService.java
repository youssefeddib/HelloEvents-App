package org.example.helloeventsapp.Service;

import org.example.helloeventsapp.Entity.Role;
import org.example.helloeventsapp.Entity.Utilisateur;
import org.example.helloeventsapp.Repository.RoleRepository;
import org.example.helloeventsapp.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UtilisateurService(UtilisateurRepository utilisateurRepository,
                              RoleRepository roleRepository,
                              PasswordEncoder passwordEncoder) {
        this.utilisateurRepository = utilisateurRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean emailExiste(String email) {
        return utilisateurRepository.findByEmail(email).isPresent();
    }

    public Optional<Utilisateur> trouverParEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return utilisateurRepository.findAll();
    }

    public Utilisateur registerUtilisateur(Utilisateur user) {
        if (emailExiste(user.getEmail())) {
            throw new RuntimeException("Email déjà utilisé");
        }

        Optional<Role> roleOptional = roleRepository.findByName(user.getRole().getName());
        if (roleOptional.isEmpty()) {
            throw new RuntimeException("Role non trouvé: " + user.getRole());
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(user.getEmail());
        utilisateur.setFullName(user.getFullName());
        utilisateur.setPassword(passwordEncoder.encode(user.getPassword()));
        utilisateur.setRole(roleOptional.get());

        return utilisateurRepository.save(utilisateur);
    }


    public Utilisateur RegisterUtilisateur(String email, String password, String fullName, String roleName) {
        if (emailExiste(email)) {
            throw new RuntimeException("Email déjà utilisé");
        }

        Optional<Role> roleOptional = roleRepository.findByName(roleName.toUpperCase());
        if (roleOptional.isEmpty()) {
            throw new RuntimeException("Role non trouvé: " + roleName);
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail(email);
        utilisateur.setFullName(fullName);
        utilisateur.setPassword(passwordEncoder.encode(password));
        utilisateur.setRole(roleOptional.get());

        return utilisateurRepository.save(utilisateur);
    }
}
