package hu.lamsoft.pizza.saloon.core.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hu.lamsoft.pizza.saloon.core.user.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	User findByEmailAndPassword(String email, String password);
	
}
