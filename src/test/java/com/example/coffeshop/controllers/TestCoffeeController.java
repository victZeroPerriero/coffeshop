package com.example.coffeshop.controllers;

import com.example.coffeshop.controller.CoffeeController;
import com.example.coffeshop.model.Coffee;
import com.example.coffeshop.service.CoffeService;
import com.example.coffeshop.util.Status;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;


@WebMvcTest(CoffeeController.class)
public class TestCoffeeController {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private  CoffeService service;
    @Autowired
    private ObjectMapper mapper;

    @Test
    public void shouldPostCoffee() throws Exception {
        Coffee request = new Coffee();
       request.setDescription("americcano");
       request.setPrice(BigDecimal.valueOf(255.12));
       request.setCreateDate(LocalDate.now());
       request.setStatus(Status.COMPLETE);
       request.setRemove(false);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/add")
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(mapper.writeValueAsString(request)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void shouldFindById() throws Exception {
        Long id = 1L;
        Coffee request = new Coffee();
        request.setDescription("capucchino");
        request.setPrice(BigDecimal.valueOf(355.12));
        request.setCreateDate(LocalDate.now());
        request.setStatus(Status.COMPLETE);
        request.setRemove(false);
        Mockito.when(service.findCoffeeById(id)).thenReturn(request);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/find/{id}", id))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(request.getDescription()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").value(request.getPrice()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.createDate").value(request.getCreateDate().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(request.getStatus().toString()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.remove").value(request.isRemove()))
                .andDo(MockMvcResultHandlers.print());

    }
}
