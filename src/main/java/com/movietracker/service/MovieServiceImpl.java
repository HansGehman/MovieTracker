package com.movietracker.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movietracker.model.Movie;
import com.movietracker.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;

	@Override
	public List<Movie> getAllMovie() {
		System.out.println("getAllMovie called");
		return movieRepository.findAll();
	}

	@Override
	public void save(Movie movie) {
		System.out.println("save called");
		if(Objects.nonNull(movie)) {
		movieRepository.save(movie);	
		}
		
	}

	@Override
	public Movie getById(Long id) {
		System.out.println("getById called");
		Movie movie = null;
		if (Objects.nonNull(id)) {
			Optional<Movie> optionalMovie = movieRepository.findById(id);
			if(optionalMovie.isPresent()) {
				movie = optionalMovie.get();
			} else {
				throw new RuntimeException("Movie not found with the id: " + id);
			}
		}
		return movie;
	}

	@Override
	public void deleteById(Long id) {
		System.out.println("deleteById called");
		if(Objects.nonNull(id)) {
			movieRepository.deleteById(id);
		}
	}

}
