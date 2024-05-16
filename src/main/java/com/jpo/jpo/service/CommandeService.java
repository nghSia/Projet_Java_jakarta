package com.jpo.jpo.service;

import com.jpo.jpo.dto.CommandeDTO.CreateCommandeDTO;
import com.jpo.jpo.model.Billet;
import com.jpo.jpo.model.Commande;
import com.jpo.jpo.repository.BilletRepository;
import com.jpo.jpo.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepository repository;
    private final BilletRepository billetRepository;
    @Autowired
    public CommandeService(CommandeRepository repository, BilletRepository billetRepository){
        this.repository = repository;
        this.billetRepository = billetRepository;
    }

    public List<Commande> getAllCommande(){
        return repository.findAll();
    }

    public Commande getCommandeByID(Long id){
        return repository.findById(id).orElse(null);
    }

    public Commande create(CreateCommandeDTO p_commande){
        Commande cmdACreer = new Commande(
            p_commande.getMontant(),
            p_commande.getType()
        );
        return repository.save(cmdACreer);
    }

    public boolean delete(Long id){
        Commande cmdASupprimer = repository.findById(id).orElse(null);
        if(cmdASupprimer != null){
            repository.delete(cmdASupprimer);
            return true;
        }
        return false;
    }

    public void addTicket(Long id, List<Billet> billets) throws ClassNotFoundException {
        Commande CmdAAjouter = repository.findById(id).orElse(null);
        if (CmdAAjouter != null) {
            CmdAAjouter.getBillets().addAll(billets);
            repository.save(CmdAAjouter);
        } else {
            throw new ClassNotFoundException("La commande avec l'ID " + id + " n'existe pas.");
        }
    }
}
