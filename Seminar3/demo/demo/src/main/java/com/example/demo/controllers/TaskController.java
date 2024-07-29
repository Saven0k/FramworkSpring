package com.example.demo.controllers;

import com.example.demo.domains.User;
import com.example.demo.services.DataProcessingService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Контроллер для управлеия задачами.
 */
@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService dataProcessingService;

    @GetMapping
    public List<String> getAllTasks(){
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")
    public List<User> sortByAge() {return dataProcessingService.sortUsersByAge(dataProcessingService.getUserRepository().getUsers());}

    @GetMapping("/filter/{age}")
    public List<User> filterByAge(@PathVariable("age") Integer age) {return dataProcessingService.filterUsersByAge(dataProcessingService.getUserRepository().getUsers(), age);}

    @GetMapping("/calc")
    public double calculateAvarageAge(){return dataProcessingService.calculateAvarageAge(dataProcessingService.getUserRepository().getUsers());}
}
