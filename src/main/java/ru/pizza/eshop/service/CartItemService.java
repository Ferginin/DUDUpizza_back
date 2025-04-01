package ru.pizza.eshop.service;

import org.springframework.stereotype.Service;
import ru.pizza.eshop.model.CartItem;
import ru.pizza.eshop.repository.CartItemRepository;

import java.util.List;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    public void addCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    public void removeCartItem(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }

    public List<CartItem> getCartItems() {
         return (List<CartItem>) cartItemRepository.findAll();
    }
}
