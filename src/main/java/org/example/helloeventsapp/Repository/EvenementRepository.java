package org.example.helloeventsapp.Repository;

import org.example.helloeventsapp.Entity.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {


}
