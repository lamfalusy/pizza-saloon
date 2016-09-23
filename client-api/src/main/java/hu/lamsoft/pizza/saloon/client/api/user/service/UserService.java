package hu.lamsoft.pizza.saloon.client.api.user.service;

import java.util.List;

import hu.lamsoft.pizza.saloon.client.api.user.vo.UserVO;

public interface UserService {

	void createUser(UserVO user);
	
	UserVO getUserByEmailAndPassword(String email, String password);
	
	List<UserVO> getUsers();
	
}
