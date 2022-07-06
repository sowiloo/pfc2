package com.example.repository;



import com.example.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjetRepository extends JpaRepository<Projet, Integer> {

}
