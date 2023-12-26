package com.example.client.Controllers;

import com.example.client.Models.Car;
import com.example.client.Models.CarClient;
import com.example.client.Models.Client;
import com.example.client.Services.ClientService;
import com.example.client.Services.QueueListener;
import com.example.client.Services.SharedDataService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;
    private final SharedDataService sharedDataService;


    @Autowired
    public ClientController(ClientService clientService, SharedDataService sharedDataService) {
        this.clientService = clientService;
        this.sharedDataService = sharedDataService;
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

    @GetMapping("/with-cars2")
    public List<Client> findAllWithCars2() {
        carClient.getAllCars();
        List<Client> clients = clientService.getAllClients();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String carsJson = sharedDataService.getCarsJson();
            if (carsJson != null) {
                List<Car> carsList = objectMapper.readValue(carsJson, new TypeReference<List<Car>>() {});

                for (Client client : clients) {
                    Long clientId = client.getId();
                    List<Car> clientCars = carsList.stream()
                            .filter(car -> car.getClientId().equals(clientId))
                            .toList();

                    client.setCars(clientCars);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clients;
    }


}