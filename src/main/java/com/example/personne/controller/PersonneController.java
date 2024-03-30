package com.example.personne.controller;

import com.example.personne.model.Personne;
import com.example.personne.service.PersonneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
public class PersonneController {

    private final PersonneService personneService;

    @GetMapping("/abdou")
    public String sendGreetings() {
        return "Hello, abdelali!";
    }

    @GetMapping("/all")
    public List<Personne> getAll() {
        return this.personneService.all();
    }

    @GetMapping("/chercher/{id}")
    public Optional<Personne> chercher(@PathVariable Long id) {
        return personneService.rechrcher(id);
    }

    @PutMapping("/modifie/{id}")
    public void modifie(@PathVariable Long id, @RequestBody Personne personne) {
        personneService.modifie(id,personne);
    }
    @PostMapping("/cree")
    public void cree(@RequestBody Personne personne) {
        personneService.cree(personne);
    }

    @DeleteMapping("/supprime/{id}")
    public void supprime(@PathVariable long id) {
        personneService.supprime(id);
    }
}