package com.example.coffeshop.service;

import com.example.coffeshop.exception.ResorceNotFound;
import com.example.coffeshop.model.Client;
import com.example.coffeshop.repo.ClientRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepo clientRepo;

    public List<Client> getAllClients(){
        return clientRepo.findAll();
    }
    public Client findById(Long id){
        return clientRepo.findById(id).orElseThrow(() -> new ResorceNotFound("client not found by id" + id));
    }
    public void createClient(Client client){
        clientRepo.save(client);
    }
}
