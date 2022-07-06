package com.example.Controller;

import com.appasso.projet.Administration;

import com.appasso.repository.AdministrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class AdministrationController {
    @Autowired
    private AdministrationRepository administrationRepository;
    @GetMapping("/administrations")
    public List<Administration> getAdministration(){
        return administrationRepository.findAll();
    }

    @GetMapping("/administrations/{id}")
    public ResponseEntity<Administration> getAdministration(@PathVariable Integer id){
        Optional<Administration> administration = administrationRepository.findById(id);
        return ResponseEntity.ok().body(administration.get());
    }

    @DeleteMapping("/administrations/{id}")
    public void deleteAdministration(@PathVariable Integer id){
        administrationRepository.deleteById(id);
    }

    @PostMapping("/administration")
    public ResponseEntity<Administration> createAdministration(@Valid @RequestBody Administration administration) throws URISyntaxException{
        if(administration.getId() != null) {
            throw new RuntimeException("une activité ne peux pas avoir le meme ID");
        }
        Administration result = administrationRepository.save(administration);
        return ResponseEntity.created(new URI("/api/administration)"+result.getId())).body(result);
    }

    @PutMapping("/administrations")
    public ResponseEntity<Administration> updateAdministration(@Valid @RequestBody Administration administration) throws URISyntaxException{
        if(administration.getId() == null) {
            throw new RuntimeException("ID invalide");
        }
        Administration result = administrationRepository.save(administration);
        return ResponseEntity.ok().body(result);
    }


}
