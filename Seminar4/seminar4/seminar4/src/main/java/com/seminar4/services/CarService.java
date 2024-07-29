package com.seminar4.services;

import com.seminar4.models.Car;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class CarService {
    List<Car> cars = new ArrayList<>();

    public void addCar(Car car){
        cars.add(car);
    }

    public List<Car> getAllCars(){
        return cars;
    }

    public Car getCarByCarMake(String carMake){
        for (Car car: cars) {
            if (Objects.equals(car.getCarMake(), carMake)) {
                return car;
            }
        }
        return null;
    }
}
