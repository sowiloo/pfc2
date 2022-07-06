package com.example.Controller;


import com.appasso.projet.Association;
import com.appasso.repository.AssociationRepository;
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
public class AssociationController {
    @Autowired AssociationRepository associationRepository;

    @GetMapping ("/associations")
    public List<Association> getAssociation(){
        return associationRepository.findAll();
    }

    @GetMapping("/associations/{id}")
    public ResponseEntity<Association> getAssociation(@PathVariable Integer id){
        Optional<Association> association = associationRepository.findById(id);
        return ResponseEntity.ok().body(association.get());
    }

    @DeleteMapping("/associations/{id}")
    public void deleteAssociation(@PathVariable Integer id){
        associationRepository.deleteById(id);
    }


    @PutMapping("/associations")
    public ResponseEntity<Association> updateAssociation(@Valid @RequestBody Association association) throws URISyntaxException{
        if(association.getId() == null) {
            throw new RuntimeException("ID invalide");
        }
        Association result = associationRepository.save(association);
        return ResponseEntity.ok().body(result);
    }

}
