package com.example.Controller;



import com.appasso.projet.Projet;
import com.appasso.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProjetController {

    @Autowired
    private ProjetRepository projetRepository;


    @GetMapping("/projets")
    public List<Projet> getAllProjet(){
        return projetRepository.findAll();
    }

    @GetMapping("projets/{projetId}")
    public ResponseEntity<Projet> getProjet(@PathVariable Integer projetId){
        Optional<Projet> projet = projetRepository.findById(projetId);
        return ResponseEntity.ok().body(projet.get());
    }

    @PostMapping("/projets")
    public ResponseEntity<Projet> createProjet(@Valid @RequestBody Projet projet) throws URISyntaxException {
        if(projet.getProjetId() != null) {
            throw new RuntimeException("un projet ne peux pas avoir le meme ID");
        }
        Projet result = projetRepository.save(projet);
        return ResponseEntity.created(new URI("/api/projets)"+result.getProjetId())).body(result);
    }

    @PutMapping("/projets")
    public ResponseEntity<Projet> updateProjet(@Valid @RequestBody Projet projet) throws URISyntaxException{
        if(projet.getProjetId()== null) {
            throw new RuntimeException("ID invalide");
        }
        Projet result = projetRepository.save(projet);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/projets/{id}")
    public void deleteProjet(@PathVariable Integer id) {
        projetRepository.deleteById(id);
    }


}
