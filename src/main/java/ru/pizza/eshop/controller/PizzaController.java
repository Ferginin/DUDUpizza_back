package ru.pizza.eshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pizza.eshop.model.Pizza;
import ru.pizza.eshop.service.PizzaService;

import java.util.List;

@RestController
@RequestMapping("/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping
    public ResponseEntity<List<Pizza>> getPizzas() {
        List<Pizza> pizzas = pizzaService.getAllPizza();
        return ResponseEntity.ok(pizzas);
    }
}
