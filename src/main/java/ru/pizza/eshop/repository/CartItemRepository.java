package ru.pizza.eshop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.pizza.eshop.model.CartItem;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem, Integer> {
}
