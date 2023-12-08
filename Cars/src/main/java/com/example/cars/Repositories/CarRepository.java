package com.example.cars.Repositories;

import com.example.cars.Models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    @Query("SELECT c FROM Car c WHERE c.clientId = :clientId")
    List<Car> findByClientId(@Param("clientId") Long clientId);
}
