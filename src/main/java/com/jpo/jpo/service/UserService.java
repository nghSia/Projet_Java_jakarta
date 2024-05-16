package com.jpo.jpo.service;

import com.jpo.jpo.dto.CommandeDTO.UpdateCommandeDTO;
import com.jpo.jpo.dto.UserDTO.CreateUserDTO;
import com.jpo.jpo.dto.UserDTO.UpdateUserDTO;
import com.jpo.jpo.model.User;
import com.jpo.jpo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;
    private final CommandeService cmdservice;

    @Autowired
    public UserService(UserRepository userRepository, CommandeService cmdservice) {
        this.repository = userRepository;
        this.cmdservice = cmdservice;
    }

    public List<User> findAllUser() { return repository.findAll(); }

    public User findUserbyID(Long id) { return repository.findById(id).orElse(null);}

    public User create(CreateUserDTO user){
        User UserACreer = new User(
                user.getPassword(),
                user.getEmail(),
                user.getRole()
        );
        return repository.save(UserACreer);
    }

    @Transactional
    public boolean delete(Long id) {
        User userASupprimer = findUserbyID(id);
        if(userASupprimer != null){
            repository.delete(userASupprimer);
            return true;
        }
        return false;
    }

    public Boolean update(Long id, CreateUserDTO user) {
        User userAModifier = findUserbyID(id);
        if(userAModifier != null){
            if(user.getEmail() == null || user.getPassword() == null | user.getRole() == null){
                return false;
            }
            userAModifier.setPassword(user.getPassword());
            userAModifier.setEmail(user.getEmail());
            userAModifier.setRole(user.getRole());
            repository.save(userAModifier);
            return true;
        }
        return false;
    }

    public boolean updatePartielle(Long id, UpdateUserDTO user) {
        User userAModifier = repository.findById(id).orElse(null);

        if(userAModifier != null){

            if(user.getPassword() != null && !user.getPassword().isEmpty()) {
                userAModifier.setPassword(user.getPassword());
            }
            if(user.getEmail() != null && !user.getEmail().isEmpty()) {
                userAModifier.setEmail(user.getEmail());
            }
            if(user.getRole() != null) {
                userAModifier.setRole(user.getRole());
            }
            repository.save(userAModifier);
            return true;
        }
        return false;
    }

//    @Transactional
//    public User ajoutCommande(Long p_user_id, Long p_cmd_id){
//        User user = repository.findById(p_user_id).orElse(null);
//        Commande cmd = cmdservice.getCommandeByID(p_cmd_id);
//        user.getCommandes().add(cmd);
//        repository.save(user);
//        return user;
//    }
}
