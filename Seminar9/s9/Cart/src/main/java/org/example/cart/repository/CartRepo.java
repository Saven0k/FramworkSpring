package org.example.cart.repository;

import org.example.cart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepo extends JpaRepository<Product, Long> {
}
