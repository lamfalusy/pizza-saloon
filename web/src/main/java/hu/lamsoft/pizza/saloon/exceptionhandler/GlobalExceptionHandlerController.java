package hu.lamsoft.pizza.saloon.exceptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class GlobalExceptionHandlerController {

	@ExceptionHandler(Throwable.class)
	public String handleException(Exception e) {
		return "error";
	}
	
}
