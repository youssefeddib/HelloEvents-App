package org.example.helloeventsapp.Repository;

import org.example.helloeventsapp.Entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByEmail(String email);
    Utilisateur findByEmailAndPassword(String email, String password);
    boolean existsByEmail(String email);
}
