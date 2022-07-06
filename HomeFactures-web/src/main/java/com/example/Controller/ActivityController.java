package com.example.Controller;

import com.appasso.projet.Activity;
import com.appasso.repository.ActivityRepository;

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
public class ActivityController {
        @Autowired
        private ActivityRepository activityRepository;


        @GetMapping("/activitys")
        public List<Activity> getAllActivity(){
            return activityRepository.findAll();
        }

        @GetMapping("/activitys/{id}")
        public ResponseEntity<Activity> getActivity(@PathVariable Integer id){
                Optional<Activity> activity = activityRepository.findById(id);
                return ResponseEntity.ok().body(activity.get());
        }

        @DeleteMapping("/activitys/{id}")
        public void deleteActivity(@PathVariable Integer id){
                activityRepository.deleteById(id);
        }

        @PostMapping("/activitys")
        public ResponseEntity<Activity> createActivity(@Valid @RequestBody Activity activity) throws URISyntaxException{
                if(activity.getId() != null) {
                        throw new RuntimeException("une activité ne peux pas avoir le meme ID");
                }
                Activity result = activityRepository.save(activity);
                return ResponseEntity.created(new URI("/api/activitys)"+result.getId())).body(result);
        }

        @PutMapping("/activitys")
        public ResponseEntity<Activity> updateActivity(@Valid @RequestBody Activity activity) throws URISyntaxException{
                if(activity.getId() == null) {
                        throw new RuntimeException("ID invalide");
                }
                Activity result = activityRepository.save(activity);
                return ResponseEntity.ok().body(result);
        }


}
