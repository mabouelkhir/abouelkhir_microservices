package com.example.client.Controllers;

import com.example.client.Models.CarClient;
import com.example.client.Models.Client;
import com.example.client.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    private CarClient carClient;

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        Client client = clientService.getClientById(id);
        return client != null ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client newClient = clientService.saveClient(client);
        return new ResponseEntity<>(newClient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/with-cars")
    public List<Client> findAllWithCars() {
        List<Client> clients = clientService.getAllClients();
        clients.forEach(client ->
                client.setCars(carClient.findByClient(client.getId())));
        return clients;
    }
}