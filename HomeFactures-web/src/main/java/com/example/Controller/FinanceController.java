package com.example.Controller;


import com.appasso.projet.Finance;

import com.appasso.repository.FinanceRepository;
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
public class FinanceController {
    @Autowired
    private FinanceRepository financeRepository;
    @GetMapping("/finance")
    public List<Finance> getFinance(){
        return financeRepository.findAll();
    }

    @GetMapping("/finance/{id}")
    public ResponseEntity<Finance> getFinance(@PathVariable Integer id){
        Optional<Finance> finance = financeRepository.findById(id);
        return ResponseEntity.ok().body(finance.get());
    }

    @PostMapping("/finances")
    public ResponseEntity<Finance> createFinance(@Valid @RequestBody Finance finance) throws URISyntaxException {
        if(finance.getId() != null) {
            throw new RuntimeException("un entrer ne peux pas avoir le meme ID");
        }
        Finance result = financeRepository.save(finance);
        return ResponseEntity.created(new URI("/api/finances)"+result.getId())).body(result);
    }

    @PutMapping("/finances")
    public ResponseEntity<Finance> updateFinance(@Valid @RequestBody Finance finance) throws URISyntaxException{
        if(finance.getId() == null) {
            throw new RuntimeException("ID invalide");
        }
        Finance result = financeRepository.save(finance);
        return ResponseEntity.ok().body(result);
    }

}
