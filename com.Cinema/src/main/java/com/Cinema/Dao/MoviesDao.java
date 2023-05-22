package com.Cinema.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Cinema.Entity.Movies;
import com.Cinema.Repository.MoviesRepository;

@Repository
public class MoviesDao {
	@Autowired
	MoviesRepository movRepo;
	public String addMovies(Movies m) {
		movRepo.save(m);
		return "Posted Successfully";
	}
	public String addMovies(List<Movies> m) {
		movRepo.saveAll(m);
		return "Listed Done";
	}

}
