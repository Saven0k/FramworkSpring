package org.example.product.repository;

import org.example.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepo extends JpaRepository<Product,Long> {

}
