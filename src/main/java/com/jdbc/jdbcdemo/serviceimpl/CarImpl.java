package com.jdbc.jdbcdemo.serviceimpl;

import com.jdbc.jdbcdemo.model.Car;
import com.jdbc.jdbcdemo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarImpl implements CarService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Car> fetchCarList() {
        String sql="select * from Car";
        List<Car> carList=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Car.class));
        return carList;
    }

    @Override
    public String addNewCar(Car car) {
        String sql="insert into Car values(?,?,?)";
        jdbcTemplate.update(sql,new Object[]{car.getId(),car.getBrand(),car.getModel()});
        return "Car added!!!";
    }
}
