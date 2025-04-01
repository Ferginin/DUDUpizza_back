package ru.pizza.eshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.pizza.eshop.model.CartItem;
import ru.pizza.eshop.service.CartItemService;

import java.util.List;

@RestController
@RequestMapping("CartItems")
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping
    public List<CartItem> getCartItems() {
        return cartItemService.getCartItems();
    }
}
