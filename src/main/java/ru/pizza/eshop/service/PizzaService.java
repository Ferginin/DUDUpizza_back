package ru.pizza.eshop.service;

import org.springframework.stereotype.Service;
import ru.pizza.eshop.model.Pizza;
import ru.pizza.eshop.repository.PizzaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getAllPizza() {
        return pizzaRepository.findAll();
    }

    public Optional<Pizza> getPizzaById(Long id) {
        return pizzaRepository.findById(id);
    }

    public Pizza createPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public Pizza updatePizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }

    public void deletePizzaById(Long id) {
        pizzaRepository.deleteById(id);
    }
}
