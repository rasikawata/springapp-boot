package com.springapp.boot.controllers;

import com.springapp.boot.domain.Greeting;
import com.springapp.boot.service.FactoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@Autowired
	FactoryDataService factoryDataService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world! Rasika");
		return "index";
	}

	@RequestMapping("/hello")
	public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "hello";
	}

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	@RequestMapping("/testData")
	public String testData() {

		Greeting greeting = new Greeting(1, "hi");
		factoryDataService.getMyData(greeting);

		return "Greetings from Spring Boot!";
	}


}