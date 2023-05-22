package com.onesoft.car.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onesoft.car.Entity.Bike;

public interface BikeRepository extends JpaRepository<Bike,Integer> {

}
