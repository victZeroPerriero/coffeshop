package com.example.coffeshop.controller;



import com.example.coffeshop.exception.ResorceNotFound;
import com.example.coffeshop.model.Client;
import com.example.coffeshop.model.Coffee;
import com.example.coffeshop.model.Oder;
import com.example.coffeshop.repo.OrderRepo;
import com.example.coffeshop.service.ClientService;
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
    private final ClientService clientService;
    private final OrderRepo orderRepo;

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
        return new ResponseEntity<>("coffee created", HttpStatus.OK);
    }

    @RequestMapping(value = "clients", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }


    @GetMapping("find/client/{id}")
    public Client findByClient(@PathVariable("id") Long id)  {
        return clientService.findById(id);

    }

    @PostMapping("create/client")
    public ResponseEntity<String> addClient(@RequestBody Client client){
        clientService.createClient(client);
        return new ResponseEntity<>("client created", HttpStatus.OK);
    }


    @PostMapping("create/order")
    public ResponseEntity<String> addOrder(@RequestBody Oder order){
        orderRepo.save(order);
        return new ResponseEntity<>("order created", HttpStatus.OK);
    }


    @RequestMapping(value = "orders", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Oder> getAllOrder(){
        return orderRepo.findAll();
    }


    @GetMapping("find/order/{id}")
    public Oder findByOrder(@PathVariable("id") Long id)  {
        return orderRepo.findById(id).orElseThrow(() -> new ResorceNotFound("order not found by id " +id));

    }

}
