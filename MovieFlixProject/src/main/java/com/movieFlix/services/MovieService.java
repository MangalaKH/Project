package com.movieFlix.services;

import java.util.List;

import com.movieFlix.entities.Movie;

public interface MovieService 
{
	public String addMovie(Movie mov);
	public List<Movie> viewMovie();
	public String deleteMovie(int id);
	public void updateMovie(Movie movie);
}


