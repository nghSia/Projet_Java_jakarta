package com.jpo.jpo.controller;

import com.jpo.jpo.dto.BilletDTO.CreateBilletDTO;
import com.jpo.jpo.dto.BilletDTO.UpdateBilletDTO;
import com.jpo.jpo.model.Billet;
import com.jpo.jpo.service.BilletService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billet")
public class BilletController {
    private final BilletService service;

    @Autowired
    public BilletController(BilletService service) { this.service = service; }

    @GetMapping
    public ResponseEntity<List<Billet>> getBillets() {
        return new ResponseEntity<>(service.getAllBillets(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Billet> getBilletById(@PathVariable Long id) {
        return new ResponseEntity<>(service.findBilletByID(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Billet> create(@Valid @RequestBody CreateBilletDTO p_billet) {
        Billet billetCreer = service.createBillet(p_billet);
        return new ResponseEntity<>(billetCreer, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        Billet billetAdelete = service.findBilletByID(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody CreateBilletDTO p_billet, @PathVariable Long id){
        boolean isUpdate = service.update(id, p_billet);
        if(isUpdate){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updatePartiellement(@PathVariable Long id, @RequestBody UpdateBilletDTO p_billet){
        boolean isUpdate = service.updatePartiellement(id, p_billet);
        if(isUpdate){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
