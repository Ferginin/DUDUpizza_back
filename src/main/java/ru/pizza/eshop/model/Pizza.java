package ru.pizza.eshop.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "pizza")
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pizza_id")
    private Long pizzaId;

    @Column(name = "price")
    private Integer pizzaPrice;

    @Column(name = "name")
    private String pizzaName;

    @Column(name = "descriprion")
    private String pizzaDescription;

    @Column(columnDefinition = "TEXT", name = "image")
    private String pizzaImage;

    @Column(name = "status")
    private Boolean status;

}
