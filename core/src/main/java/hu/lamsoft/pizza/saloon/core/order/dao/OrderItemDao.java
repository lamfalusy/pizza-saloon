package hu.lamsoft.pizza.saloon.core.order.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.lamsoft.pizza.saloon.core.order.entity.OrderItem;

@Repository
public interface OrderItemDao extends JpaRepository<OrderItem, Long> {

}
