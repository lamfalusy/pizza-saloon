package hu.lamsoft.pizza.saloon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import hu.lamsoft.pizza.saloon.authentication.PizzaSaloonAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private PizzaSaloonAuthenticationProvider pizzaSaloonAuthenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http
	        .authorizeRequests()
	            .antMatchers("/", "/home", "/registration", "/registration/**", "/css/**", "/js/**").permitAll()
	            .antMatchers("/user", "/pizza").hasAnyAuthority("ADMIN")
	            .anyRequest().authenticated()
	            .and()
	        .formLogin()
	            .loginPage("/login")
	            .permitAll()
	            .and()
	        .logout()
	        	.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
	        	.logoutSuccessUrl("/")
	            .permitAll()
	            .and()
	        .exceptionHandling().accessDeniedPage("/home");
	}
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(pizzaSaloonAuthenticationProvider);
    }
	
}
