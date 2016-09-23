package hu.lamsoft.pizza.saloon.core.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.lamsoft.pizza.saloon.client.api.user.service.UserService;
import hu.lamsoft.pizza.saloon.client.api.user.vo.UserVO;
import hu.lamsoft.pizza.saloon.core.common.modelmapper.service.ModelMapperService;
import hu.lamsoft.pizza.saloon.core.user.dao.UserDao;
import hu.lamsoft.pizza.saloon.core.user.entity.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private ModelMapperService modelMapperService;
	
	@Override
	public void createUser(UserVO user) {
		userDao.save(modelMapperService.convert(user, User.class));
	}

	@Override
	public List<UserVO> getUsers() {
		return modelMapperService.convert(userDao.findAll(), UserVO.class);
	}

	@Override
	public UserVO getUserByEmailAndPassword(String email, String password) {
		return modelMapperService.convert(userDao.findByEmailAndPassword(email, password), UserVO.class);
	}

}
