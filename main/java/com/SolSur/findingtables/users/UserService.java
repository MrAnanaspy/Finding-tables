package com.SolSur.findingtables.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean add(User user){
        User userFromDb = userRepository.findByEmail(user.getEmail());
        if (userFromDb != null){
            return false;
        }
        userRepository.save(user);
        return true;

    }

    public List<User> list(){
        return userRepository.findAll();
    }

    public void delete(Long userId){
        userRepository.deleteById(userId);
    }
}
