package com.example.coffeshop.service;

import com.example.coffeshop.exception.ResorceNotFound;
import com.example.coffeshop.model.Coffee;
import com.example.coffeshop.repo.CoffeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CoffeService {

    private final CoffeeRepository coffeeRepository;
    public List<Coffee> getAllCoffee(){
        return coffeeRepository.findAll();
    }
    public void addCoffee(Coffee coffee){
        coffeeRepository.save(coffee);
    }
    public Coffee findCoffeeById(Long id)  {
      return coffeeRepository.findById(id).orElseThrow(()-> new ResorceNotFound("coffee not found by id: " + id));
    }
    public void removeCoffe(Long id){
        coffeeRepository.deleteById(id);
    }
}
