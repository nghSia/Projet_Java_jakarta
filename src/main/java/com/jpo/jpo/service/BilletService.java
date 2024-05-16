package com.jpo.jpo.service;

import com.jpo.jpo.dto.BilletDTO.CreateBilletDTO;
import com.jpo.jpo.dto.BilletDTO.UpdateBilletDTO;
import com.jpo.jpo.model.Billet;
import com.jpo.jpo.repository.BilletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BilletService {
    private final BilletRepository repository;

    @Autowired
    public BilletService(BilletRepository repository) { this.repository = repository; }

    public List<Billet> getAllBillets() {
        return repository.findAll();
    }

    public Billet findBilletByID(Long id) { return repository.findById(id).orElse(null); }

    public Billet createBillet(CreateBilletDTO billet) {
        Billet billetACreer = new Billet(
                billet.getPrix(),
                billet.getNom()
        );
        return repository.save(billetACreer);
    }

    public boolean delete(Long id) {
        Billet billetASupp = repository.findById(id).orElse(null);
        if(billetASupp != null) {
            repository.delete(billetASupp);
            return true;
        }
        return false;
    }

    public boolean update(Long id, CreateBilletDTO p_billet) {
        Billet billetAUpdate = repository.findById(id).orElse(null);
        if(billetAUpdate != null) {
            if(p_billet.getPrix() !=null || p_billet.getNom() !=null) {
                billetAUpdate.setPrix(p_billet.getPrix());
                billetAUpdate.setNomTicket(p_billet.getNom());
                repository.save(billetAUpdate);
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean updatePartiellement(Long id, UpdateBilletDTO p_billet) {
        Billet billetAUpdate = repository.findById(id).orElse(null);
        if(billetAUpdate != null) {
            if(p_billet.getPrix() != null) {
                billetAUpdate.setPrix(p_billet.getPrix());
            }
            if(p_billet.getNom() != null) {
                billetAUpdate.setNomTicket(p_billet.getNom());
            }
            repository.save(billetAUpdate);
            return true;
        }
        return false;
    }
}
