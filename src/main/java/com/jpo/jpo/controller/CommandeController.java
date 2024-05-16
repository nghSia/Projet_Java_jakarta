package com.jpo.jpo.controller;

import com.jpo.jpo.dto.CommandeDTO.CreateCommandeDTO;
import com.jpo.jpo.model.Billet;
import com.jpo.jpo.model.Commande;
import com.jpo.jpo.service.CommandeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commande")
public class CommandeController {
    private final CommandeService service;

    @Autowired
    public CommandeController(CommandeService service){this.service = service;}

    @GetMapping
    public ResponseEntity<List<Commande>> getAllCommande(){
        return new ResponseEntity<>(service.getAllCommande(), HttpStatus.OK);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Commande> getCommandeByID(@PathVariable Long id){
        return new ResponseEntity<>(service.getCommandeByID(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Commande> create(@Valid @RequestBody CreateCommandeDTO p_cmd){
        Commande createUser = service.create(p_cmd);
        return  new ResponseEntity<>(createUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{cmdId}/ajouter-billet")
    public ResponseEntity<?> ajouterBillet(@PathVariable Long cmdId, @RequestBody List<Billet> billets){
        try{
            service.addTicket(cmdId, billets);
            return ResponseEntity.ok().build();
        } catch ( Exception e ){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
