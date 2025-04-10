package ru.pizza.eshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pizza.eshop.DTO.PizzaDto;
import ru.pizza.eshop.model.Pizza;
import ru.pizza.eshop.repository.PizzaRepository;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Pizza getPizzaById(Long id) {
        return pizzaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Пицца не найдена"));
    }

    public Pizza createPizza(PizzaDto pizzaDto) {
        Pizza pizza = new Pizza();
        pizza.setPizzaName(pizzaDto.getPizzaName());
        pizza.setPizzaPrice(pizzaDto.getPizzaPrice());
        pizza.setPizzaDescription(pizzaDto.getPizzaDescription());
        pizza.setPizzaImage(pizzaDto.getPizzaImage());
        pizza.setStatus(pizzaDto.getStatus());
        return pizzaRepository.save(pizza);
    }

    public Pizza updatePizza(Long id, PizzaDto pizzaDto) {
        Pizza pizza = getPizzaById(id);
        pizza.setPizzaName(pizzaDto.getPizzaName());
        pizza.setPizzaPrice(pizzaDto.getPizzaPrice());
        pizza.setPizzaDescription(pizzaDto.getPizzaDescription());
        pizza.setPizzaImage(pizzaDto.getPizzaImage());
        pizza.setStatus(pizzaDto.getStatus());
        return pizzaRepository.save(pizza);
    }

    public void deletePizza(Long id) {
        pizzaRepository.deleteById(id);
    }
}