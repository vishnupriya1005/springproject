package com.Cinema.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Cinema.Entity.Movies;

public interface MoviesRepository extends JpaRepository<Movies,Integer> {

}
