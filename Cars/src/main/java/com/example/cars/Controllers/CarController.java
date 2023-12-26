package com.example.cars.Controllers;

import com.example.cars.Config.RabbitMqConfig;
import com.example.cars.Models.Car;
import com.example.cars.Services.CarService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    RabbitTemplate template;


    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getAllCars() {
        List<Car> cars= carService.getAllCars();
        template.convertAndSend(RabbitMqConfig.EXCHANGE,RabbitMqConfig.ROUTING_KEY,cars);
        return "Success";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Car car = carService.getCarById(id);
        return car != null ? ResponseEntity.ok(car) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody Car car) {
        Car newCar = carService.saveCar(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/Client/{clientId}")
    public List<Car> getCarsByClientId(@PathVariable Long clientId) {
        return carService.findByClient(clientId);
    }


}