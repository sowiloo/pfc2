package com.example.repository;

import com.appasso.projet.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ActivityRepository extends JpaRepository<Activity, Integer> {
}
