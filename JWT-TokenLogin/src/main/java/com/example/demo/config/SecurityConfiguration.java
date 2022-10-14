package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.demo.service.UserService;

@Configuration
@EnableWebSecurity
public abstract class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	

	 @Autowired
	 public UserService userService;

	//private JwtF

	// which authonication use decide this in memmory or database
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//	super.configure(auth);
		auth.userDetailsService(userService);
	}



	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		System.out.println("Point Called::=>>");
		http .csrf()
		.disable()
		.cors()
		.disable()
		.authorizeHttpRequests()
		.antMatchers("/home/auth/").permitAll().and().authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	
	
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	/*
	 * @Override
	 *
	 * @Bean public AuthenticationManager authenticationManager () throws Exception
	 * { return super.authenticationManagerBean();
	 *
	 * }
	 */
  /*
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	
}
   */
	
	

}
