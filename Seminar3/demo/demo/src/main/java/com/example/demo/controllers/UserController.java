package com.example.demo.controllers;

import com.example.demo.domains.User;
import com.example.demo.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Контроллер для получения списка users и добавления user в body.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList(){
        return service.getService().getUserRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user){
        service.getService().getUserRepository().getUsers().add(user);
        return "User added from body!";
    }
}
