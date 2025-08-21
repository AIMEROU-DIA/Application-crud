package sn.aimerou.crid_springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.aimerou.crid_springboot.entity.Personne;
import sn.aimerou.crid_springboot.repository.PersonneRepository;

@RestController
@RequestMapping("/api/persons")
public class PersonneController {

    private final PersonneRepository personneRepository;

    public PersonneController(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    // Récupérer toutes les personnes
    @GetMapping
    public ResponseEntity<List<Personne>> getAllPersons() {
        return new ResponseEntity<>(personneRepository.findAll(), HttpStatus.OK);
    }

    // Créer une nouvelle personne
    @PostMapping
    public ResponseEntity<Personne> createPerson(@RequestBody Personne personne) {
        Personne personCreated = personneRepository.save(personne);
        return new ResponseEntity<>(personCreated, HttpStatus.CREATED);
    }

    // Récupérer une personne par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Personne> getPersonById(@PathVariable Long id) {
        Optional<Personne> person = personneRepository.findById(id);

        return person.map(p -> new ResponseEntity<>(p, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Mettre à jour une personne existante
    @PutMapping("/{id}")
    public ResponseEntity<Personne> updatePerson(@PathVariable Long id, @RequestBody Personne updatedPerson) {
        if (!personneRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        updatedPerson.setId(id);
        Personne savedPerson = personneRepository.save(updatedPerson);

        return new ResponseEntity<>(savedPerson, HttpStatus.OK);
    }

    // Supprimer une personne par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable Long id) {
        if (!personneRepository.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        personneRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}