package com.example.passwordmanager.passwordmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }


    public void registerUser (User user){
        //error here
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()){
            throw new IllegalStateException("User already created with email");
        }
        userRepository.save(user);
    }

    // Delete user route
    public void deleteUser(Long userId){
        boolean userExists = userRepository.existsById(userId);
        if (!userExists){
            throw new IllegalStateException("User with id: "+ userId + "does not exist in database");
        }
        userRepository.deleteById(userId);
    }


    // User update route
    @Transactional
    public void updateUser(Long userId, String name, String email){
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User with id: "+ userId + "does not exist"));

        if (name != null && name.length() > 0 && !Objects.equals(user.getName(), name)){
            user.setName(name);
        }



        if (email != null && email.length()>0 && !Objects.equals(user.getEmail(),email)){
            Optional<User> userOptional = userRepository.findUserByEmail(email);
            if (userOptional    .isPresent()){
                throw new IllegalStateException("Email is taken ");
            }
            user.setEmail(email);
        }

    }


}
