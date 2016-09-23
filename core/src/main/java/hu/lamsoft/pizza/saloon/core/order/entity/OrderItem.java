package hu.lamsoft.pizza.saloon.core.order.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import hu.lamsoft.pizza.saloon.core.common.entity.BaseEntity;
import hu.lamsoft.pizza.saloon.core.pizza.entity.Pizza;

@Entity
public class OrderItem extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	@OneToOne
	@JoinColumn(name = "pizza_id")
	private Pizza pizza;

	public OrderItem() {
		// Nothing to do
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String toString() {
		return "OrderItem [order=" + order + ", pizza=" + pizza + "]";
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
		OrderItem other = (OrderItem) obj;
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
