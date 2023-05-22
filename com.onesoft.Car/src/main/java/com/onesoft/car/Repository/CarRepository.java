package com.onesoft.car.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.onesoft.car.Entity.Car;

public interface CarRepository extends JpaRepository<Car,Integer> {




}
