package com.jpo.jpo.controller;

import com.jpo.jpo.DTO.CreateUser;
import com.jpo.jpo.DTO.UpdateUser;
import com.jpo.jpo.model.User;
import com.jpo.jpo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @Autowired
    public UserController(UserService service) {this.service = service;}

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(service.findAllUser(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = service.findUserbyID(id);
        if(user != null) {
            return new ResponseEntity<>(service.findUserbyID(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<User> save(@Valid @RequestBody CreateUser user) {
        User createdUser = service.create(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean isDeleted = service.delete(id);
        if(isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> mettreAJourTotalement(
            @PathVariable Long id,
            @RequestBody UpdateUser user) {
        boolean isUpdated = service.update(id, user);
        if(isUpdated) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> mettreAjourPartiellement(
            @PathVariable Long id,
            @RequestBody UpdateUser user) {
        boolean isUpdated = service.updatePartielle(id, user);
        if(isUpdated) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
