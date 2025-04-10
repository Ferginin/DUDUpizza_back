package ru.pizza.eshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.pizza.eshop.DTO.CartItemDto;
import ru.pizza.eshop.model.CartItem;
import ru.pizza.eshop.service.CartItemService;

import java.util.List;

@RestController
@RequestMapping("/cart-items")
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping
    public ResponseEntity<List<CartItem>> getAllCartItems() {
        List<CartItem> cartItems = cartItemService.getAllCartItems();
        return ResponseEntity.ok(cartItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CartItem> getCartItemById(@PathVariable Long id) {
        CartItem cartItem = cartItemService.getCartItemById(id);
        return ResponseEntity.ok(cartItem);
    }

    @PostMapping
    public ResponseEntity<CartItem> createCartItem(@RequestBody CartItemDto cartItemDto) {
        CartItem cartItem = cartItemService.createCartItem(cartItemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cartItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CartItem> updateCartItem(
            @PathVariable Long id,
            @RequestBody CartItemDto cartItemDto
    ) {
        CartItem cartItem = cartItemService.updateCartItem(id, cartItemDto);
        return ResponseEntity.ok(cartItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long id) {
        cartItemService.deleteCartItem(id);
        return ResponseEntity.noContent().build();
    }
}