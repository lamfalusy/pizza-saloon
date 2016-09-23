package hu.lamsoft.pizza.saloon.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import hu.lamsoft.pizza.saloon.client.api.user.service.UserService;
import hu.lamsoft.pizza.saloon.client.api.user.vo.UserVO;

@Component
public class PizzaSaloonAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		final UserVO user = userService.getUserByEmailAndPassword(authentication.getName(), String.valueOf(authentication.getCredentials()));
		if(user != null) {
	        List<GrantedAuthority> grantedAuths = new ArrayList<>(1);
	        grantedAuths.add(new SimpleGrantedAuthority(user.getRole()));
	        return new UsernamePasswordAuthenticationToken(authentication.getName(), authentication.getCredentials(), grantedAuths);
	    } else {
	        return null;
	    }
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
