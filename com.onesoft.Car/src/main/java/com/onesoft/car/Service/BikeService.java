package com.onesoft.car.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.onesoft.car.Dao.BikeDao;
import com.onesoft.car.Entity.Bike;

@Service
public class BikeService {
	@Autowired
	BikeDao bikeDao;

	public String addBike(Bike b) {
		return bikeDao.addBike(b);
	}

	public String addBike(List<Bike> b) {
		return bikeDao.addBike(b);
	}

	public Bike getBikeById(@PathVariable int id) {
		return bikeDao.getBikeById(id);
	}

	public List<Bike> getBike() {
		return bikeDao.getBike();
	}

	public List<Bike> getbrand(String brand) {
		List<Bike> allbike = bikeDao.getBike();
		return allbike.stream().filter(i -> i.getBrand().equals(brand)).collect(Collectors.toList());
	}

	public List<Bike> getcolor(String color) {
		List<Bike> allbike = bikeDao.getBike();
		return allbike.stream().filter(i -> i.getColor().equals(color)).collect(Collectors.toList());
	}
	public List<Bike> getcc(){
		List<Bike> allbike=bikeDao.getBike();
		allbike.forEach(i->{
			if(i.getCc()>=120 && i.getCc()<=200) {
				i.setPrice(i.getPrice()+i.getPrice()*5/100);
			} else if(i.getCc()>=220 && i.getCc()<=300) {
				i.setPrice(i.getPrice()+i.getPrice()*10/100);
			} else if(i.getCc()>=500) {
				i.setPrice(i.getPrice()+i.getPrice()*15/100);
			}
		});
		return allbike;
	}
	public List<String> getBrand(int price){
		List<Bike> allBike=bikeDao.getBike();
		return allBike.stream().filter(i->i.getPrice()==price).map(l->l.getBrand()).collect((Collectors.toList()));
		
	}
	
}
