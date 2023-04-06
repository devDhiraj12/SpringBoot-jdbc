package com.jdbc.jdbcdemo.serviceimpl;

import com.jdbc.jdbcdemo.model.Car;
import com.jdbc.jdbcdemo.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public String updateCar(Car car) {
        String sql="update car set brand=?, model=? where id=?";
        jdbcTemplate.update(sql,new Object[]{car.getBrand(),car.getModel(),car.getId()});
        return "Car Updated!!!";
    }

    @Override
    public String deleteCar(Long id) {
        String sql="delete from car where id=?";
        jdbcTemplate.update(sql,new Object[]{id});
        return "Car Removed!!!";
    }

    @Override
    public List<Map<String, Object>> fetchCarListByBrand(Long brandId) {
        String sql="select c.id,c.name as carName,b.name as brandName from car c,brand b where b.id=c.brand_id and b.id=?;";
        List<Map<String,Object>> carList = jdbcTemplate.queryForList(sql,new Object[]{brandId});
        return carList;
    }

    @Override
    public String testAop() {
        System.out.println();
        return "hello AOP";
    }


}
