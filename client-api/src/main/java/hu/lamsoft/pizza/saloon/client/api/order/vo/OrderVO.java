package hu.lamsoft.pizza.saloon.client.api.order.vo;

import java.util.List;

import hu.lamsoft.pizza.saloon.client.api.user.vo.UserVO;
import hu.lamsoft.pizza.saloon.client.common.vo.BaseVO;

public class OrderVO extends BaseVO {

	private UserVO user;
	
	private List<OrderItemVO> orderItems;
	
	public OrderVO() {
		// Nothing to do
	}

	public UserVO getUser() {
		return user;
	}

	public void setUser(UserVO user) {
		this.user = user;
	}

	public List<OrderItemVO> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItemVO> orderItems) {
		this.orderItems = orderItems;
	}

	@Override
	public String toString() {
		return "OrderVO [user=" + user + ", orderItems=" + orderItems + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((orderItems == null) ? 0 : orderItems.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderVO other = (OrderVO) obj;
		if (orderItems == null) {
			if (other.orderItems != null)
				return false;
		} else if (!orderItems.equals(other.orderItems))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
}
