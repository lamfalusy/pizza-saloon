package hu.lamsoft.pizza.saloon.core.pizza.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.lamsoft.pizza.saloon.client.api.pizza.service.PizzaService;
import hu.lamsoft.pizza.saloon.client.api.pizza.vo.PizzaVO;
import hu.lamsoft.pizza.saloon.core.common.modelmapper.service.ModelMapperService;
import hu.lamsoft.pizza.saloon.core.pizza.dao.PizzaDao;
import hu.lamsoft.pizza.saloon.core.pizza.entity.Pizza;

@Service
public class PizzaServiceImpl implements PizzaService {

	@Autowired
	private PizzaDao pizzaDao;
	
	@Autowired
	private ModelMapperService modelMapperService;
	
	@Override
	public void createPizza(PizzaVO pizza) {
		pizzaDao.save(modelMapperService.convert(pizza, Pizza.class));
	}

	@Override
	public List<PizzaVO> getPizzas() {
		return modelMapperService.convert(pizzaDao.findAll(), PizzaVO.class);
	}

}
