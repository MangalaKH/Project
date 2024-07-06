package com.movieFlix.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController
{
	@GetMapping("map-register")
	public String mapRegister()
	{
		return "register";
	}
	
	@GetMapping("map-login")
	public String mapLogin()
	{
		return "login";
	}
	  
	@GetMapping("map-addmovie")
	public String mapaddMovie()
	{
		return "addmovie";
	}
	
	@GetMapping("deleteuser")
	public String mapdeleteUser()
	{
		return "deleteuser";
	}
	
	@GetMapping("deletemovie")
	public String mapdeleteMovie()
	{
		return "deletemovie";
	}
	
	@GetMapping("adminhome")
	public String adminhome()
	{
		return "adminhome";
	}
	
	@GetMapping("map-updateprofile")
	public String mapupdateprofile()
	{
		return "updateprofile";
	}
	
	@GetMapping("map-updatemovie")
	public String mapupdatemovie()
	{
		return "updatemovie";
	}
}
