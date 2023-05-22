package com.Cinema.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Cinema.Entity.Movies;
import com.Cinema.Service.MoviesService;

@RestController
public class MoviesController {

	@Autowired
	MoviesService movSer;

	@RequestMapping(value = "/addmovies")
	public String addMovies(@RequestBody Movies m) {
		return movSer.addMovies(m);
	}
	@RequestMapping(value="/addmovlist")
	public String addMovies(@RequestBody List<Movies> m){
		return movSer.addMovies(m);
	}
}
