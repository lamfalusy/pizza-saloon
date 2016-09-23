package hu.lamsoft.pizza.saloon.client.api.order.service;

import java.util.List;

import hu.lamsoft.pizza.saloon.client.api.order.vo.OrderVO;
import hu.lamsoft.pizza.saloon.client.api.user.vo.UserVO;

public interface OrderService {

	void createOrder(OrderVO order);
	
	List<OrderVO> getOrdersByUser(UserVO user);
	
}
