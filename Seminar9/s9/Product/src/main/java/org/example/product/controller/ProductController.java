package org.example.product.controller;

import lombok.AllArgsConstructor;
import org.example.product.model.Product;
import org.example.product.repository.ProductsRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@AllArgsConstructor
@RequestMapping("/product")
public class ProductController {

  private ProductsRepo productsRepo;

  @GetMapping("/hello")
  public String hello(){
    return "Hello from products";
  }

  @GetMapping()
  public List<Product> getAllProducts(){
    return productsRepo.findAll();
  }
  @PostMapping("")
  public Product addProduct(@RequestBody Product product){
    return productsRepo.save(product);
  }

  @GetMapping("/{name}")
  public Product getByName(@PathVariable String name){
    for(Product product: getAllProducts()){
      if (Objects.equals(product.getTitle(), name)){
        return product;
      }
    }
    return new Product();
  }
}
