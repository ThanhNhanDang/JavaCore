package com.java.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("prototype")
@RequestMapping(name = "home")
public class HomeController {
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home() {
		return "view/home/home.html";
	}
	@RequestMapping(value = "home/add", method = RequestMethod.GET)
	public String add() {
		return "view/home/add.html";
	}
}
