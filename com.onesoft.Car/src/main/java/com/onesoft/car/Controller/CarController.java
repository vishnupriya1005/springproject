package com.onesoft.car.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onesoft.car.Entity.Car;
import com.onesoft.car.Service.CarService;
@RequestMapping(value="car")
@RestController
public class CarController {
	@Autowired
	CarService carser;

	@RequestMapping(value = "/addcar")
	public String addCar(@RequestBody Car c) {
		return carser.addCar(c);
	}

	@RequestMapping(value = "/addList")
	public String addCar(@RequestBody List<Car> c) {
		return carser.addCar(c);
	}

	@RequestMapping(value = "/getCarById/{id}")
	public Car getCarById(@PathVariable int id) {
		return carser.getCarById(id);
	}

	@GetMapping(value = "/getList")
	public List<Car> getcar() {
		return carser.getCar();
	}

	@DeleteMapping(value = "/deleteById/{id}")
	public String deletecar(@PathVariable int id) {
		return carser.deletecar(id);
	}

	@PutMapping(value = "/updateCar/{id}")
	public String updatecar(@RequestBody Car id) {
		return carser.updatecar(id);
	}
	@RequestMapping(path="/getbrand/{brand}")
	public List<Car> getbrand(@PathVariable String brand){
		return carser.getbrand(brand);
	}
	@RequestMapping(path="/getcolor/{color}")
	public List<Car> getcolor(@PathVariable String color){
		return carser.getcolor(color);
	}
	@RequestMapping(path="/getprice")
	public List<Car> getprice(){
		return carser.getprice();
	}
}