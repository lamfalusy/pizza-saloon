package hu.lamsoft.pizza.saloon.core.pizza.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.lamsoft.pizza.saloon.core.pizza.entity.Pizza;

@Repository
public interface PizzaDao extends JpaRepository<Pizza, Long> {

}
