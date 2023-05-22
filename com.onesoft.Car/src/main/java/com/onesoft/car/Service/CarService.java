package com.onesoft.car.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.onesoft.car.Dao.CarDao;
import com.onesoft.car.Entity.Car;

@Service
public class CarService {
	@Autowired
	CarDao cardao;
	public String addCar(Car c) {
		return cardao.addCar(c);
	}
	public String addCar(List<Car> c) {
		return cardao.addCar(c);
	}
	public Car getCarById(@PathVariable int id) {
		return cardao.getCarById(id);
	}
	public List<Car> getCar(){
		return cardao.getCar();
	}
	public String deletecar(int id) {
		return cardao.deletecar(id);
	}
	public String updatecar(Car id) {
		return cardao.updatecar(id);
	}
	public List<Car> getbrand(String brand){
		List<Car> allcar=cardao.getCar();
		return allcar.stream().filter(i->i.getBrand().equals(brand)).collect(Collectors.toList());
	}
	public List<Car> getcolor(String color){
		List<Car> allcar=cardao.getCar();
		return allcar.stream().filter(i->i.getColor().equals(color)).collect(Collectors.toList());
	}
	public List<Car> getprice(){
		List<Car> allcar=cardao.getCar();
allcar.forEach(i->{
	if(i.getCc()>=120 && i.getCc()<=200) {
		i.setPrice(i.getPrice()+i.getPrice()*5/100);
	} else if(i.getCc()>=220 && i.getCc()<=300) {
		i.setPrice(i.getPrice()+i.getPrice()*10/100);
	} else if(i.getCc()>=500) {
		i.setPrice(i.getPrice()+i.getPrice()*15/100);
	}
});
return allcar;
	}
	}

