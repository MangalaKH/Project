package com.movieFlix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movieFlix.entities.Movie;

public interface MovieRepo extends JpaRepository<Movie, Integer>
{

}
