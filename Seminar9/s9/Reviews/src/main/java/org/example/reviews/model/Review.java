package org.example.reviews.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Review {
    public Review() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Не знаю как соеденить с микросервисом product
     */
//    @Column(nullable = false)
//    private Product product;

    @Column(nullable = false)
    private String name;

    @Column(nullable= false)
    private String content;
}
