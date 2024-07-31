package org.example.cart.contoller;

import lombok.AllArgsConstructor;
import org.example.cart.model.Product;
import org.example.cart.repository.CartRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/cart")
public class CartController {
  private CartRepo cartRepo;

  @GetMapping("/hello")
  public String hello(){
    return "Hello from cart";
  }

  @GetMapping
  public List<Product> getAllFromCart(){return cartRepo.findAll();}


  @PostMapping("/add")
  public Product addProduct(@RequestBody Product produt){
    return cartRepo.save(produt);
  }

  @GetMapping("/delete/{id}")
  public void deleteProduct(@PathVariable Long id){
    cartRepo.deleteById(id);
  }
  @GetMapping("/buy")
  public String buy(){
    double s1 = 0.0;
    for (Product product: getAllFromCart()){
      s1 += product.getPrice();
    }
    return "Итоговая сумма: " + s1 + " .";

  }

}
