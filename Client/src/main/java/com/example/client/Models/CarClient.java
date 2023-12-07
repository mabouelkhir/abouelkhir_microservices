package com.example.client.Models;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@FeignClient(name = "cars-service", url = "http://localhost:8082") // Replace with actual URL

@HttpExchange
public interface CarClient {
    @GetExchange("/cars/Client/{clientId}")
    public List<Car> findByClient(@PathVariable("clientId") Long clientId);

}
