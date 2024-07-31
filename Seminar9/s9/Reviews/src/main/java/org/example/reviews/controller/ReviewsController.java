package org.example.reviews.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewsController {
  @GetMapping("/hello")
  public String hello() {
    return "Hello from reviews";
  }
}
