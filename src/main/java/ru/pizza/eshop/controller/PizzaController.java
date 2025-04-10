package ru.pizza.eshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pizza.eshop.DTO.PizzaDto;
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

    // Получить все пиццы
    @GetMapping
    public ResponseEntity<List<Pizza>> getAllPizzas() {
        List<Pizza> pizzas = pizzaService.getAllPizzas();
        return ResponseEntity.ok(pizzas);
    }

    // Получить пиццу по ID
    @GetMapping("/{id}")
    public ResponseEntity<Pizza> getPizzaById(@PathVariable Long id) {
        Pizza pizza = pizzaService.getPizzaById(id);
        return ResponseEntity.ok(pizza);
    }

    // Создать новую пиццу
    @PostMapping
    public ResponseEntity<Pizza> createPizza(@RequestBody PizzaDto pizzaDto) {
        Pizza pizza = pizzaService.createPizza(pizzaDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(pizza);
    }

    // Обновить пиццу
    @PutMapping("/{id}")
    public ResponseEntity<Pizza> updatePizza(
            @PathVariable Long id,
            @RequestBody PizzaDto pizzaDto
    ) {
        Pizza pizza = pizzaService.updatePizza(id, pizzaDto);
        return ResponseEntity.ok(pizza);
    }

    // Удалить пиццу
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePizza(@PathVariable Long id) {
        pizzaService.deletePizza(id);
        return ResponseEntity.noContent().build();
    }
}