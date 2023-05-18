package com.movietracker.service;

import java.util.List;

import com.movietracker.model.Movie;

public interface MovieService {
	
	List<Movie> getAllMovie();
	
	void save(Movie movie);
	
	Movie getById(Long id);
	
	void deleteById(Long id);

}
