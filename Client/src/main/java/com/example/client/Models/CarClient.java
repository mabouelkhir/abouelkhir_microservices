package com.example.client.Models;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@FeignClient(name = "CARS-SERVICE:8082") // Replace with actual URL

public interface CarClient {
    @GetMapping("/cars/Client/{clientId}")
    public List<Car> findByClient(@PathVariable("clientId") Long clientId);

}
