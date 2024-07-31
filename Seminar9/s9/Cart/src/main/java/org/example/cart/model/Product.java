package org.example.cart.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    public Product(){

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private double price;
}
