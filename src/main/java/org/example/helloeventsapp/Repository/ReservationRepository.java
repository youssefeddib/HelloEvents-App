package org.example.helloeventsapp.Repository;

import org.example.helloeventsapp.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByUtilisateurId(Long utilisateurId);

    List<Reservation> findByEvenementId(Long evenementId);
}
