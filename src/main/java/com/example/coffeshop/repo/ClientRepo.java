package com.example.coffeshop.repo;

import com.example.coffeshop.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {
}
