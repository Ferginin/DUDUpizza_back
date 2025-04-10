package ru.pizza.eshop.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartItemDto {
    @NotNull(message = "Количество не может быть пустым")
    @Positive(message = "Количество должно быть положительным")
    private Integer quantity;

    @NotNull(message = "Размер не может быть пустым")
    @Positive(message = "Размер должен быть положительным")
    private Integer size;

    @NotBlank(message = "Тип теста не может быть пустым")
    private String doughType;

    private List<String> ingredients;

    @NotNull(message = "Цена не может быть пустой")
    @Positive(message = "Цена должна быть положительной")
    private Double price;

    @NotNull(message = "ID пользователя не может быть пустым")
    private Long userId;

    @NotNull(message = "ID пиццы не может быть пустым")
    private Long pizzaId;
    
}