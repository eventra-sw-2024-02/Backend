package com.example.demo.service;

import com.example.demo.controller.user.request.LoginRequest;
import com.example.demo.controller.client.response.ClientResponse;
import com.example.demo.entity.Business;
import com.example.demo.entity.ClientEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.entity.enums.UserRole;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private BusinessService businessService;

    public UserEntity createUser(UserEntity user) {
        UserEntity createdUser = userRepository.save(user);
        System.out.println("Usuario normal creado con éxito: " + createdUser.getEmail());
        System.out.println(createdUser.getPassword());
        if (createdUser.getRole().equals(UserRole.CLIENT)) {
            System.out.println("Usuario Cliente creado con éxito");
            ClientResponse client=clientService.createClientwUser(createdUser);
        }else if (createdUser.getRole().equals(UserRole.BUSINESS)) {
            System.out.println("Usuario Business creado con exito");
            Business business=businessService.createBusinesswUser(user);
        }
        return createdUser;
    }

    public Object login(LoginRequest loginRequest){
        System.out.println("uno");
        Optional<UserEntity> user= userRepository.findByEmail(loginRequest.email());
        if (user.isPresent()) {
            System.out.println("email correcto");
            if(user.get().getPassword().equals(loginRequest.password())){
                System.out.println("password correcto");
                if (user.get().getRole().equals(UserRole.CLIENT)) {
                    System.out.println("devolviendo al cliente");
                    return clientService.getClientByUserResponse(user.get().getId());
                }else if (user.get().getRole().equals(UserRole.BUSINESS)){
                    System.out.println("devolviendo al negocio");
                    return businessService.getBusinessResponse(user.get().getId());
                } else{
                    System.out.println("devolviendo nada");
                    return null;
                }
            }
            else{
                throw new RuntimeException("Wrong Password");
            }
        } else {
            throw new RuntimeException("Email Not Found");
        }

    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public ClientEntity loginUser(LoginRequest loginRequest) {
        Optional<UserEntity> user= userRepository.findByEmail(loginRequest.email());
        if (user.isEmpty()) { throw new RuntimeException("Email Not Found"); }
        else{
            if (!user.get().getPassword().equals(loginRequest.password())) {
                throw new RuntimeException("Wrong Password");
            } else{
                if (user.get().getRole().equals("CLIENT")) {
                    return clientService.getClientByUser(user.get().getId()).get();
                }
                else if (user.get().getRole().equals("BUSINESS")) {
                    return null;
                }
            }
        }
        return null;
    }

}
