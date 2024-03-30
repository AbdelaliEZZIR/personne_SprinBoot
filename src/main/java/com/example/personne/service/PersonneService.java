package com.example.personne.service;

import com.example.personne.model.Personne;
import com.example.personne.repository.PersonneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PersonneService {

    private final PersonneRepository personneRepository ;

    public List<Personne> all(){
        return personneRepository.findAll();
    }
    public void cree(Personne personne){
        Personne p = new Personne();
        p.setId(personne.getId());
        p.setNom(personne.getNom());
        p.setPrenom(personne.getPrenom());
        p.setAge(personne.getAge());
        personneRepository.save(p);
    }

    public Optional<Personne> rechrcher(long id){
        return personneRepository.findById(id);
    }

    public void supprime(long id ){
        personneRepository.deleteById(id);
    }

    public void modifie(long id, Personne personne ){
       personneRepository.findById(id)
                .map(
                p->{
                    p.setAge(personne.getAge());
                    p.setNom(personne.getNom());
                    p.setPrenom(personne.getPrenom());
                    return personneRepository.save(p);
                }).orElseThrow(()-> new RuntimeException(""));

    }



}
