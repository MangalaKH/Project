package com.movieFlix.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.movieFlix.entities.Movie;
import com.movieFlix.services.MovieService;

@Controller
public class MovieController
{
	@Autowired
	MovieService movserv;
	
	@PostMapping("addmovie")
	public String addMovie(@ModelAttribute Movie mov)
	{
		movserv.addMovie(mov);
		return "addmoviesuccess";
	}
	
	@GetMapping("viewmovie")
	public String viewMovie(Model model)
	{
		List<Movie> movieList = movserv.viewMovie();
		model.addAttribute("movie", movieList);
		return "viewmovie";
	}

	@GetMapping("viewmovieuser")
	public String viewmovieuser(Model model)
	{
		List<Movie> movieList = movserv.viewMovie();
		model.addAttribute("movie", movieList);
		return "viewmovieuser";
	}
	
	@PostMapping("deletemovieid")
	public String deleteMovie(@RequestParam("id") int id)
	{
		movserv.deleteMovie(id);
		return "deletemoviesuccess";
	}
	@PostMapping("updatemovie")
	public String updateMovie(@ModelAttribute Movie movie)
	{
		movserv.updateMovie(movie);
		return "updatemoviesuccess";
	}

}
