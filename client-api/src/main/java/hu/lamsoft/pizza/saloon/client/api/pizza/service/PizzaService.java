package hu.lamsoft.pizza.saloon.client.api.pizza.service;

import java.util.List;

import hu.lamsoft.pizza.saloon.client.api.pizza.vo.PizzaVO;

public interface PizzaService {

	void createPizza(PizzaVO pizza);
	
	List<PizzaVO> getPizzas();
	
}
