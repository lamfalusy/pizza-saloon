package hu.lamsoft.pizza.saloon.core.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.lamsoft.pizza.saloon.client.api.order.service.OrderService;
import hu.lamsoft.pizza.saloon.client.api.order.vo.OrderVO;
import hu.lamsoft.pizza.saloon.client.api.user.vo.UserVO;
import hu.lamsoft.pizza.saloon.core.common.modelmapper.service.ModelMapperService;
import hu.lamsoft.pizza.saloon.core.order.dao.OrderDao;
import hu.lamsoft.pizza.saloon.core.order.entity.Order;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ModelMapperService modelMapperService;
	
	@Override
	public void createOrder(OrderVO order) {
		orderDao.save(modelMapperService.convert(order, Order.class));
	}

	@Override
	public List<OrderVO> getOrdersByUser(UserVO user) {
		return modelMapperService.convert(orderDao.findAll(), OrderVO.class);
	}

}
