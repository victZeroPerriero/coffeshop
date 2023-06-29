package com.example.coffeshop.controller;


import com.example.coffeshop.exception.ResorceNotFound;
import com.example.coffeshop.model.Coffee;
import com.example.coffeshop.service.CoffeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/")
@RequiredArgsConstructor
public class CoffeeController {
    private final CoffeService coffeService;
    @RequestMapping(value = "coffees", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Coffee> getAll(){
        return coffeService.getAllCoffee();
    }
    @GetMapping("find/{id}")
    public Coffee findByCoffe(@PathVariable("id") Long id)  {
      return coffeService.findCoffeeById(id);

    }
    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody Coffee coffee){
        coffeService.addCoffee(coffee);
        return new ResponseEntity<>("coffee created", HttpStatus.CREATED);
    }
}
