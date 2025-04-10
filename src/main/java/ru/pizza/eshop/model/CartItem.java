package ru.pizza.eshop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Entity
@Setter
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_items_id")
    private Long cartId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "size")
    private Integer size;

    @Column(name = "dough_type")
    private String doughType;

    @ElementCollection
    @CollectionTable(
            name = "cart_item_ingredients",
            joinColumns = @JoinColumn(name = "cart_item_id")
    )
    @Column(name = "ingredient")
    private List<String> ingredients;

    @Column(name = "price")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pizza_id")
    private Pizza pizza;

}
