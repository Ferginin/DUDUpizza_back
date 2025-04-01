package ru.pizza.eshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pizza.eshop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
