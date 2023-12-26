package com.example.client.Services;

import org.springframework.stereotype.Component;

@Component
public class SharedDataService {
    private String carsJson;

    public String getCarsJson() {
        return carsJson;
    }

    public void setCarsJson(String carsJson) {
        this.carsJson = carsJson;
    }
}
