package com.IndianGroceries.controller;


import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller{
	
	@RequestMapping("/welcome")
	public String welcome() {
		try {
			System.out.println(Controller.class.getResource("/static/").getPath());
		return "forward:/Welcome.html";
	}
		catch(Exception e) {
			System.out.println(e);
			return "welcome";
		}
		
	}
	
}