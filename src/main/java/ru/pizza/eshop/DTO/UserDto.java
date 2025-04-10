package ru.pizza.eshop.DTO;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @NotBlank(message = "Имя пользователя не может быть пустым")
    private String username;

    @NotBlank(message = "Пароль не может быть пустым")
    private String password;

    @Email(message = "Некорректный email")
    private String email;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Некорректный номер телефона")
    private String phone;

    private String address;

}