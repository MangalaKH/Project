package com.movieFlix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movieFlix.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>
{
	public User findByEmail(String email);
}