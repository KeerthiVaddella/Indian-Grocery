package com.IndianGroceries.controller;


import org.springframework.web.bind.annotation.RequestMapping;


@org.springframework.stereotype.Controller
public class Controller{
	
	@RequestMapping("/welcome")
	public String welcome() {
		
			System.out.println(Controller.class.getResource("/static/").getPath());
		return "redirect:/Welcome.html";
	
		
	}
	
}