package com.example.client.Services;

import com.example.client.Config.RabbitMqConfig;
import com.example.client.Models.Car;
import com.example.client.Models.CarClient;
import com.example.client.Models.Client;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class QueueListener {

    private final SharedDataService sharedDataService;

    public QueueListener(SharedDataService sharedDataService) {
        this.sharedDataService = sharedDataService;
    }
    public String carsJson  ;
    // Getter and Setter for carsJson
    public String getCarsJson() {
        return carsJson;
    }

    public void setCarsJson(String carsJson) {
        this.carsJson = carsJson;
    }
    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void receiveMessage(Car[] cars) {
        // Convert the received array of cars to JSON string and print it
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            carsJson = objectMapper.writeValueAsString(cars);
            sharedDataService.setCarsJson(carsJson);
            System.out.println("Received cars:");
            System.out.println(carsJson);

        } catch (JsonProcessingException e) {
            // Handle the exception appropriately
            e.printStackTrace();
        }

        // Further processing logic if needed
    }

}
