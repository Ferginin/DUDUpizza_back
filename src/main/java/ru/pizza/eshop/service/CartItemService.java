package ru.pizza.eshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pizza.eshop.DTO.CartItemDto;
import ru.pizza.eshop.model.CartItem;
import ru.pizza.eshop.model.Pizza;
import ru.pizza.eshop.model.User;
import ru.pizza.eshop.repository.CartItemRepository;
import ru.pizza.eshop.repository.PizzaRepository;
import ru.pizza.eshop.repository.UserRepository;

import java.util.List;

@Service
public class CartItemService {

    private final CartItemRepository cartItemRepository;
    private final PizzaRepository pizzaRepository;
    private final UserRepository userRepository;

    public CartItemService(CartItemRepository cartItemRepository, PizzaRepository pizzaRepository, UserRepository userRepository) {
        this.cartItemRepository = cartItemRepository;
        this.pizzaRepository = pizzaRepository;
        this.userRepository = userRepository;
    }

    public List<CartItem> getAllCartItems() {
        return (List<CartItem>) cartItemRepository.findAll();
    }

    public CartItem getCartItemById(Long id) {
        return cartItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Элемент корзины не найден"));
    }

    public CartItem createCartItem(CartItemDto cartItemDto) {
        Pizza pizza = pizzaRepository.findById(cartItemDto.getPizzaId())
                .orElseThrow(() -> new RuntimeException("Пицца не найдена"));
        User user = userRepository.findById(cartItemDto.getUserId())
                .orElseThrow(() -> new RuntimeException("Пользователь не найден"));

        CartItem cartItem = new CartItem();
        cartItem.setQuantity(cartItemDto.getQuantity());
        cartItem.setSize(cartItemDto.getSize());
        cartItem.setDoughType(cartItemDto.getDoughType());
        cartItem.setIngredients(cartItemDto.getIngredients());
        cartItem.setPrice(cartItemDto.getPrice());
        cartItem.setPizza(pizza);
        cartItem.setUser(user);

        return cartItemRepository.save(cartItem);
    }

    public CartItem updateCartItem(Long id, CartItemDto cartItemDto) {
        CartItem cartItem = getCartItemById(id);
        cartItem.setQuantity(cartItemDto.getQuantity());
        cartItem.setSize(cartItemDto.getSize());
        cartItem.setDoughType(cartItemDto.getDoughType());
        cartItem.setIngredients(cartItemDto.getIngredients());
        cartItem.setPrice(cartItemDto.getPrice());
        return cartItemRepository.save(cartItem);
    }

    public void deleteCartItem(Long id) {
        cartItemRepository.deleteById(id);
    }
}