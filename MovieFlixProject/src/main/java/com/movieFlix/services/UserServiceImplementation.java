package com.movieFlix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieFlix.entities.User;
import com.movieFlix.repositories.UserRepo;

@Service
public class UserServiceImplementation implements UserService
{
	@Autowired
	UserRepo urepo;
	
	@Override
	public String addUsers(User usr)
	{
		urepo.save(usr);
		return "User is created";
	}
	
	public boolean emailExits(String email)
	{
		if(urepo.findByEmail(email)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean checkUser(String email, String password)
	{
		User usr=urepo.findByEmail(email);
		
		if(urepo.findByEmail(email)==null)
		{
			return false;
		}
		
		String db_password=usr.getPassword();
		if(db_password.equals(password))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public List<User> viewUser() 
	{
		List<User> userList=urepo.findAll();
		return userList;
	}

	@Override
	public User getUser(String email) 
	{
		User user = urepo.findByEmail(email);
		return user;
	}

	@Override
	public String deleteUser(int id) 
	{
		urepo.deleteById(id);
		return "User deleted successfully";
	}

	@Override
	public String updateUser(User user)
	{
		urepo.save(user);
		return null;
	}

	@Override
	public void updateProfile(String name, String email, String password, String gender, double phone, String address)
	{
		User status = urepo.findByEmail(email);
		if(status != null)
		{
		status.setName(name);
		status.setPassword(password);
		status.setGender(gender);
		status.setPhone(phone);
		status.setAddress(address);
		urepo.save(status);
		}
	}
}
