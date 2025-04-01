package ru.pizza.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pizza.eshop.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
