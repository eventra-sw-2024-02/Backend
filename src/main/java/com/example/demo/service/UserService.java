package com.example.demo.service;

import com.example.demo.controller.user.request.LoginRequest;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserEntity user) {
        return userRepository.save(user);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public UserEntity loginUser(LoginRequest loginRequest) {
        Optional<UserEntity> user= userRepository.findByEmail(loginRequest.email());
        if (user.isEmpty()) { throw new RuntimeException("Email Not Found"); }
        else{
            if (!user.get().getPassword().equals(loginRequest.password())) {
                throw new RuntimeException("Wrong Password");
            }
        }
        return user.get();
    }

}
