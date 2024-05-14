package com.jpo.jpo.service;

import com.jpo.jpo.DTO.CreateUser;
import com.jpo.jpo.DTO.UpdateUser;
import com.jpo.jpo.model.User;
import com.jpo.jpo.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository userRepository) { this.repository = userRepository; }

    public List<User> findAllUser() { return repository.findAll(); }

    public User findUserbyID(Long id) { return repository.findById(id).orElse(null);}

    public User create(CreateUser user){
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
        if(userASupprimer != null && userASupprimer.getDeletedAt() == null){
            userASupprimer.setDeletedAt(LocalDateTime.now());
            repository.delete(userASupprimer);
            return true;
        }
        return false;
    }

    public Boolean update(Long id, UpdateUser user) {
        User userAModifier = findUserbyID(id);
        if(userAModifier != null){
            userAModifier.setPassword(user.getPassword());
            userAModifier.setEmail(user.getEmail());
            userAModifier.setRole(user.getRole());
            repository.save(userAModifier);
            return true;
        }
        return false;
    }

    public boolean updatePartielle(Long id, UpdateUser user) {
        User userAModifier = findUserbyID(id);

        if(userAModifier != null){
            if(!user.getPassword().isEmpty()) {
                userAModifier.setPassword(user.getPassword());
            }
            if(!user.getEmail().isEmpty()) {
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
}
