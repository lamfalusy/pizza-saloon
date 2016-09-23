package hu.lamsoft.pizza.saloon.authentication;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import hu.lamsoft.pizza.saloon.client.api.user.vo.UserVO;

@Component
public class PizzaSaloonAuthenticationHelper {

    @Autowired
    protected AuthenticationManager authenticationManager;
	
	public void authenticateUser(UserVO user, HttpServletRequest request) {
		String username = user.getEmail();
        String password = user.getPassword();
        List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority(user.getRole()));
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password, grantedAuths);
        request.getSession();
        token.setDetails(new WebAuthenticationDetails(request));
        Authentication authenticatedUser = authenticationManager.authenticate(token);
        SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
	}
	
}
