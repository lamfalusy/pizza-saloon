package hu.lamsoft.pizza.saloon.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.lamsoft.pizza.saloon.client.api.pizza.service.PizzaService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PizzaService pizzaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadPage() {
		ModelAndView model = new ModelAndView("home");
		model.addObject("pizzas", pizzaService.getPizzas());
		return model;
	}
	
}
