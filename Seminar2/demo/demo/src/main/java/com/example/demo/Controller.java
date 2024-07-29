package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Класс для использования сервиса в качестве вывода информации для клиента
@RestController
public class Controller {

    @Autowired
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/")
    public String hello(){
        return service.hello();
    }
}
