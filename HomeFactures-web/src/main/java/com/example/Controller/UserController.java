package com.example.Controller;

import com.appasso.projet.User;
import com.appasso.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/users")
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUser(@PathVariable Integer id){
        Optional<User> user = userRepository.findById(id);
        return ResponseEntity.ok().body(user.get());
    }


    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {
        if(user.getUserID() != null) {
            throw new RuntimeException("un user ne peux pas avoir le meme ID");
        }
        User result = userRepository.save(user);
        return ResponseEntity.created(new URI("/api/users)"+result.getUserID())).body(result);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@Valid @RequestBody User user) throws URISyntaxException{
        if(user.getUserID()== null) {
            throw new RuntimeException("ID invalide");
        }
        User result = userRepository.save(user);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userRepository.deleteById(id);
    }

}
