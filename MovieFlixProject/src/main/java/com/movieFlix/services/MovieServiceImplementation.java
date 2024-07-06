package com.movieFlix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.movieFlix.entities.Movie;
import com.movieFlix.repositories.MovieRepo;

@Service
public class MovieServiceImplementation implements MovieService
{
	@Autowired
	MovieRepo movrepo;

	@Override
	public String addMovie(Movie mov) 
	{
		movrepo.save(mov);
		return "movie is added";
	}

	@Override
	public List<Movie> viewMovie()
	{
		List<Movie>movieList = movrepo.findAll();
		return movieList;
	}

	@Override
	public String deleteMovie(int id)
	{
		movrepo.deleteById(id);
		return "Movie deleted successfully";
	}

	@Override
	public void updateMovie(Movie movie) 
	{
		movrepo.save(movie);
	}
}
