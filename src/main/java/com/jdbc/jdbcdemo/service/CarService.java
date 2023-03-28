package com.jdbc.jdbcdemo.service;

import com.jdbc.jdbcdemo.model.Car;

import java.util.List;

public interface CarService {
    List<Car> fetchCarList();

    String addNewCar(Car car);
}
