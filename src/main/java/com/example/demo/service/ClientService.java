package com.example.demo.service;

import com.example.demo.controller.client.request.ClientRequest;
import com.example.demo.entity.ClientEntity;
import com.example.demo.repository.ClientRepository; // Asegúrate de tener el repositorio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private UserService userService;

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
    }

    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<ClientEntity> getClientById(Long id) {
        return clientRepository.findById(id);
    }
}