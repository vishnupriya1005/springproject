package com.onesoft.car.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onesoft.car.Entity.Car;
import com.onesoft.car.Repository.CarRepository;

@Repository
public class CarDao {
@Autowired
CarRepository carRepo;
public String addCar(Car c) {
	carRepo.save(c);
	return "Successfully saved";
}
public String addCar(List<Car> c) {
	carRepo.saveAll(c);
	return "Succesfully saved";
}
public Car getCarById(int id) {
	return carRepo.findById(id).get();
}
public List<Car> getCar(){
	return carRepo.findAll();
}
public String deletecar(int id) {
	carRepo.deleteById(id);
	return "deleted successfully";
}

public String updatecar(Car id) {
	// TODO Auto-generated method stub
	carRepo.save(id);
	return "updated successfully";
}
}
