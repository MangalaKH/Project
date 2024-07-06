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
import com.movieFlix.entities.User;
import com.movieFlix.services.MovieService;
import com.movieFlix.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController
{
	@Autowired
	UserService userv;
	
	@Autowired
	MovieService movserv;
	
	@PostMapping("register")
	public String addUsers(@ModelAttribute User usr)
	{
		boolean status = userv.emailExits(usr.getEmail());
		if(status == true)
		{
			return "regfail";
		}
		else
		{
			userv.addUsers(usr);
			return "registersuccess";
		}
	}
	
	
	@PostMapping("login")
	public String validateUser(@RequestParam String email, @RequestParam String password, HttpSession session)
	{
		boolean loginStatus = userv.checkUser(email, password);
		if(loginStatus == true)
		{
			session.setAttribute("email", email);
			if(email.equals("admin@gmail.com"))
			{
				return "adminhome";
			}
			else
			{
			return "home";
			}
		}
		else
		{
			return "loginfail";
		}
	}
	
	@GetMapping("viewuser")
	public String viewUser(Model model)
	{
		List<User>userList = userv.viewUser();
		model.addAttribute("user", userList);
		return "viewuser";
	}
	
	@GetMapping("exploremovies")
	public String exploreMovie( Model model,HttpSession session)
	{
		//Getting the email from session
		String email = (String)session.getAttribute("email");
		//Getting the user details for email
		User usr=userv.getUser(email);
		//Checking whether user is premium
		if(usr.isPremium()== true)
		{
			//Getting the list of movies
			List<Movie> movieList = movserv.viewMovie();
			//Adding the movie details in model
			model.addAttribute("movie", movieList);
			//If premium, show movies
			return "viewmovieuser";
		}
		else
		{
			//Otherwise, make payment
			return "payment";
		}
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "login";
	}
	
	@PostMapping("deleteuserid")
	public String deleteUser(@RequestParam("id") int id)
	{
		userv.deleteUser(id);
		return "deleteusersuccess";
	}
	
	@PostMapping("updateprofile")
	public String updateProfile(HttpSession session,@RequestParam String name, String password, String gender, double phone, String address)
	{
		String email=(String)session.getAttribute("email");
		userv.updateProfile(name,  email, password,  gender, phone, address);
		return "updateusersuccess";
	}
}
