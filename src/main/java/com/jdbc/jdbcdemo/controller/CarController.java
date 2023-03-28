package com.jdbc.jdbcdemo.controller;

import com.jdbc.jdbcdemo.model.Car;
import com.jdbc.jdbcdemo.service.CarService;
import com.jdbc.jdbcdemo.serviceimpl.CarImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/getCarList")
    public List<Car> getCarList(){
        return carService.fetchCarList();
    }

    @PostMapping("/addCar")
    public String addCar(@RequestBody Car car){
        return carService.addNewCar(car);
    }
}
