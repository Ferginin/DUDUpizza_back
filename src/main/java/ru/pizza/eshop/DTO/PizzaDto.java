package ru.pizza.eshop.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PizzaDto {
    @NotBlank(message = "Название пиццы не может быть пустым")
    private String pizzaName;

    @NotNull(message = "Цена не может быть пустой")
    @Positive(message = "Цена должна быть положительной")
    private Integer pizzaPrice;

    @NotBlank(message = "Описание не может быть пустым")
    private String pizzaDescription;

    @NotBlank(message = "Изображение не может быть пустым")
    private String pizzaImage;

    @NotNull(message = "Статус не может быть пустым")
    private Boolean status;

}