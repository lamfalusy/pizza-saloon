package hu.lamsoft.pizza.saloon.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

	@RequestMapping(method = RequestMethod.GET)
	public String getTest() {
		return "test";
	}
	
}
