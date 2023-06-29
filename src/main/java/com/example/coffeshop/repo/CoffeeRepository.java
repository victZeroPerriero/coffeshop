package com.example.coffeshop.repo;

import com.example.coffeshop.model.Coffee;
import com.example.coffeshop.util.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    List<Coffee> getCoffeeByStatus(Status status);
}
