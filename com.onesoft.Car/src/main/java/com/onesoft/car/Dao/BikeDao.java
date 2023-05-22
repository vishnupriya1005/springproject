package com.onesoft.car.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.onesoft.car.Entity.Bike;
import com.onesoft.car.Repository.BikeRepository;

@Repository
public class BikeDao {
@Autowired
BikeRepository bikeRepo;
public String addBike(Bike b) {
	bikeRepo.save(b);
	return "Saved Successfully";
}
public String addBike(List<Bike> b){
	bikeRepo.saveAll(b);
	return "Added Successfully";
}
public Bike getBikeById(int id) {
	return bikeRepo.findById(id).get();
}
public List<Bike> getBike(){
	return bikeRepo.findAll();
}
}
