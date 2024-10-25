package com.example.demo.controller.client;

import com.example.demo.controller.client.request.ClientRequest;
import com.example.demo.entity.ClientEntity;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients") // Base path para los clientes
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<ClientEntity> createClient(@RequestBody ClientRequest clientRequest) {
        ClientEntity createdClient = clientService.createClient(clientRequest);
        return ResponseEntity.ok(createdClient);
    }

    @GetMapping
    public ResponseEntity<List<ClientEntity>> getAllClients() {
        List<ClientEntity> clients = clientService.getAllClients();
        return ResponseEntity.ok(clients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientEntity> getClientById(@PathVariable Long id) {
        Optional<ClientEntity> client = clientService.getClientById(id);
        return client.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
