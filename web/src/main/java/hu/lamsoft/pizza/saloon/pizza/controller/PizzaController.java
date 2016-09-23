package hu.lamsoft.pizza.saloon.pizza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.lamsoft.pizza.saloon.client.api.pizza.service.PizzaService;
import hu.lamsoft.pizza.saloon.client.api.pizza.vo.PizzaVO;

@Controller
@RequestMapping(value = "/pizza")
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadPage() {
		ModelAndView model = new ModelAndView("pizzas");
		model.addObject("pizzas", pizzaService.getPizzas());
		model.addObject("pizza", new PizzaVO());
		return model;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createPizza(@ModelAttribute(value="pizza") PizzaVO pizza) {
		pizzaService.createPizza(pizza);
		return "redirect:";
	}
	
}
