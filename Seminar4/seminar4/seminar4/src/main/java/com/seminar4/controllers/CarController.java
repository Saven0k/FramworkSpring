package com.seminar4.controllers;

import com.seminar4.models.Car;
import com.seminar4.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping()
    public String getAllCars(Model model){
        model.addAttribute("cars",carService.getAllCars());
        return "cars";
    }

    @PostMapping()
    public String addCar(Car car, Model model){
        carService.addCar(car);
        model.addAttribute("cars", carService.getAllCars());
        return "cars";
    }

    @GetMapping("/{carMake}")
    public String viewCar(@PathVariable String carMake, Model model) {
        model.addAttribute("car", carService.getCarByCarMake(carMake));
        return "car";
    }

}
