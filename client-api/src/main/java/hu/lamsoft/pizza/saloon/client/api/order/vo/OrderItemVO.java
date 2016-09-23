package hu.lamsoft.pizza.saloon.client.api.order.vo;

import hu.lamsoft.pizza.saloon.client.api.pizza.vo.PizzaVO;
import hu.lamsoft.pizza.saloon.client.common.vo.BaseVO;

public class OrderItemVO extends BaseVO {

	private OrderVO order;

	private PizzaVO pizza;
	
	public OrderItemVO() {
		// Nothing to do here
	}

	public OrderVO getOrder() {
		return order;
	}

	public void setOrder(OrderVO order) {
		this.order = order;
	}

	public PizzaVO getPizza() {
		return pizza;
	}

	public void setPizza(PizzaVO pizza) {
		this.pizza = pizza;
	}

	@Override
	public String toString() {
		return "OrderItemVO [order=" + order + ", pizza=" + pizza + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((pizza == null) ? 0 : pizza.hashCode());
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
		OrderItemVO other = (OrderItemVO) obj;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (pizza == null) {
			if (other.pizza != null)
				return false;
		} else if (!pizza.equals(other.pizza))
			return false;
		return true;
	}
	
}
