package org.example.helloeventsapp.Service;

import org.example.helloeventsapp.Entity.Evenement;
import org.example.helloeventsapp.Repository.EvenementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvenementService {

    private final EvenementRepository evenementRepository;

    @Autowired
    public EvenementService(EvenementRepository evenementRepository) {
        this.evenementRepository = evenementRepository;
    }

    public Evenement createEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    public List<Evenement> getAllEvenements() {
        return evenementRepository.findAll();
    }

    public Evenement getEvenementById(Long id) {
        return evenementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Événement non trouvé avec ID: " + id));
    }

    public Evenement updateEvenement(Long id, Evenement updatedEvent) {
        return evenementRepository.findById(id).map(e -> {
            e.setTitre(updatedEvent.getTitre());
            e.setDescription(updatedEvent.getDescription());
            e.setDateEvenement(updatedEvent.getDateEvenement());
            e.setLieu(updatedEvent.getLieu());
            e.setCategorie(updatedEvent.getCategorie());
            return evenementRepository.save(e);
        }).orElseThrow(() -> new RuntimeException("Événement non trouvé avec ID: " + id));
    }

    public void deleteEvenement(Long id) {
        if (!evenementRepository.existsById(id)) {
            throw new RuntimeException("Événement introuvable pour suppression");
        }
        evenementRepository.deleteById(id);
    }
}
