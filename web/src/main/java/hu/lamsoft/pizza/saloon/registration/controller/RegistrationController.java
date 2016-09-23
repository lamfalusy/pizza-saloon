package hu.lamsoft.pizza.saloon.registration.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import hu.lamsoft.pizza.saloon.authentication.PizzaSaloonAuthenticationHelper;
import hu.lamsoft.pizza.saloon.client.api.user.service.UserService;
import hu.lamsoft.pizza.saloon.client.api.user.vo.UserVO;

@Controller
@RequestMapping(value = "/registration")
public class RegistrationController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PizzaSaloonAuthenticationHelper pizzaSaloonAuthenticationHelper;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loadPage() {
		ModelAndView model = new ModelAndView("registration");
		model.addObject("user", new UserVO());
		return model;
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createRegistration(@ModelAttribute(value="user") UserVO user, HttpServletRequest request) {
		user.setRole("USER");
		userService.createUser(user);
		pizzaSaloonAuthenticationHelper.authenticateUser(user, request);
		return "redirect:/home";
	}
	
}
