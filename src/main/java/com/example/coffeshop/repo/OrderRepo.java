package com.example.coffeshop.repo;

import com.example.coffeshop.model.Oder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Oder,Long> {
}
