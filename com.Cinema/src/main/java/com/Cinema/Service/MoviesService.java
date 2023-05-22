package com.Cinema.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Cinema.Dao.MoviesDao;
import com.Cinema.Entity.Movies;

@Service
public class MoviesService {
	@Autowired
	MoviesDao movDao;
	
	public String addMovies(Movies m) {
		return movDao.addMovies(m);
	}
	public String addMovies(List<Movies> m) {
		return movDao.addMovies(m);
	}
}
