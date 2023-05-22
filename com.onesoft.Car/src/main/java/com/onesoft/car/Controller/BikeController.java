package com.onesoft.car.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onesoft.car.Entity.Bike;
import com.onesoft.car.Service.BikeService;

@RestController
@RequestMapping(value="/bike")
public class BikeController {
@Autowired 
BikeService bikeSer;
@PostMapping(value="/addBike")
public String addBike(@RequestBody Bike b) {
	return bikeSer.addBike(b);
}
@PostMapping(value="/addlist")
public String addBike(@RequestBody List<Bike> b){
	return bikeSer.addBike(b);
}
@RequestMapping(value="/findbyid/{id}")
public Bike getBikeById(@PathVariable int id) {
	return bikeSer.getBikeById(id);
}
@GetMapping(value="/getlist")
public List<Bike> getBike(){
	return bikeSer.getBike();
}
@GetMapping(path="/getbrand/{brand}")
public List<Bike> getbrand(@PathVariable String brand){
	return bikeSer.getbrand(brand);
}
@RequestMapping(path="/getcolor/{color}")
public List<Bike> getcolor(@PathVariable String color){
	return bikeSer.getcolor(color);
}
@RequestMapping(path="/getcc")
public List<Bike> getcc() {
	return bikeSer.getcc();
}
@RequestMapping(path="/getBrand/{price}")
public List<String> getBrand(@PathVariable int price) {
	return bikeSer.getBrand(price);
}
}
