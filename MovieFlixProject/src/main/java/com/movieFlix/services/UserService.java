package com.movieFlix.services;

import java.util.List;
import com.movieFlix.entities.User;

public interface UserService 
{
	public String addUsers(User user);
	public boolean emailExits(String email);
	public boolean checkUser(String email, String password);
	public List<User> viewUser();
	public User getUser(String email);
	public String updateUser(User user);
	public String deleteUser(int id);
	public void updateProfile(String name, String email, String password, String gender, double phone, String address);
}
