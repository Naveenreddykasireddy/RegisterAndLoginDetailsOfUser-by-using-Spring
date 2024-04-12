package com.jsp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jsp.Dao.UserDao;
import com.jsp.Dto.User;

@Controller
public class UserController 
{
	@Autowired
	UserDao d;
	
	
	@RequestMapping("/register")
	public ModelAndView registerUser()
	{
		ModelAndView  mv=new ModelAndView();
		
		mv.addObject("user", new User());
		mv.setViewName("register.jsp");
		return mv;
	}
	
	@RequestMapping("/save")
	public ModelAndView userRegister(User u)
	{
		ModelAndView mv=new ModelAndView();
		d.saveUser(u);
		mv.setViewName("/login");
		
		return mv;
	}
	@RequestMapping("/login")
	public ModelAndView loginUser()
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("user", new User());
		mv.setViewName("login.jsp");
		return mv;
	}
	
	@RequestMapping("/userLogin")
	public ModelAndView userLogin(@ModelAttribute User u)
	{
		int n=d.validateUser(u);
		
		if(n==1)
		{
		ModelAndView mv=new ModelAndView();
		mv.addObject("message", "Login successful");
		mv.setViewName("welcome.jsp");
		return mv;
		}
		else
		{
			ModelAndView mv=new ModelAndView();
			mv.addObject("message", "Invalid email or password");
			mv.setViewName("login.jsp");
			return mv;
		}
		
	}
}

