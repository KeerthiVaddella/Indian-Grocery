package com.IndianGroceries.controller;


import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller{
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	
}