package hu.lamsoft.pizza.saloon.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hu.lamsoft.pizza.saloon.client.api.order.service.OrderService;
import hu.lamsoft.pizza.saloon.client.api.order.vo.OrderVO;

@RestController
@RequestMapping(value = "/order")
public class OrderRestController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<OrderVO> getOrders() {
		// TODO replace null parameter call
		return orderService.getOrdersByUser(null);
	}
	
}
