package hu.lamsoft.pizza.saloon.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.lamsoft.pizza.saloon.client.api.user.service.UserService;
import hu.lamsoft.pizza.saloon.client.api.user.vo.UserVO;

@Controller
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadPage() {
		ModelAndView model = new ModelAndView("users");
		model.addObject("users", userService.getUsers());
		model.addObject("user", new UserVO());
		return model;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createPizza(@ModelAttribute(value="user") UserVO user) {
		userService.createUser(user);
		return "redirect:";
	}
	
}
