package com.movietracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.movietracker.model.Movie;
import com.movietracker.service.MovieService;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("allmovielist", movieService.getAllMovie());
		return "index";
	}
	
	@GetMapping("/add")
	public String addNewMovie(Model model) {
		Movie movie = new Movie();
		model.addAttribute("movie", movie);
		return "addMovie";
	}
	
	@PostMapping("/save")
	public String saveMovie(@ModelAttribute("movie") Movie movie) {
		movieService.save(movie);
		return "redirect:/";
	}
	
	@GetMapping("updateform/{id}")
	public String updateForm(@PathVariable(value = "id") long id, Model model) {
		Movie movie = movieService.getById(id);
		model.addAttribute("movie", movie);
		return "update";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteById(@PathVariable(value = "id") long id) {
		movieService.deleteById(id);
		return "redirect:/";
	}
}
