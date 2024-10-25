package com.example.demo.service;

import com.example.demo.controller.client.request.ClientRequest;
import com.example.demo.controller.user.request.LoginRequest;
import com.example.demo.entity.ClientEntity;
import com.example.demo.entity.UserEntity;
import com.example.demo.repository.ClientRepository; // Asegúrate de tener el repositorio
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    /*
    public ClientEntity createClient(ClientRequest clientRequest) {
        ClientEntity client = new ClientEntity();
        client.setRealName(clientRequest.realName());
        client.setBirthDate(clientRequest.birthDate());
        client.setDni(clientRequest.dni());
        client.setCountry(clientRequest.country());
        client.setGender(clientRequest.gender());
        client.setDirection(clientRequest.direction());
        client.setPhone(clientRequest.phone());
        client.setUser(userService.getUserById(clientRequest.userId()).get());
        return clientRepository.save(client);
    }*/

    public ClientEntity createClientwUser(UserEntity user) {
        ClientEntity client = new ClientEntity();
        client.setUser(user);
        return clientRepository.save(client);
    }

    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<ClientEntity> getClientById(Long id) {
        return clientRepository.findById(id);
    }


    public Optional<ClientEntity> getClientByUser(Long id) {
        return clientRepository.findByUser_Id(id);
    }

    /*
    public ClientEntity loginClient(LoginRequest loginRequest) {
        return getClientById(userService.loginUser(loginRequest).getId())
                .orElseThrow(() -> new IllegalArgumentException("Este usuario no es cliente"));
    }*/

}
