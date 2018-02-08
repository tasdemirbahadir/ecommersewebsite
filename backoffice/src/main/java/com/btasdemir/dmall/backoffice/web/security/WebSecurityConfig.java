package com.btasdemir.dmall.backoffice.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/javax.faces.resource/**")
        	.permitAll().anyRequest().authenticated();
		
		http.authorizeRequests().antMatchers("/manage/**").access("hasRole('ADMIN', 'MODERATOR')");
		
		http.formLogin().  //login configuration
	        loginPage("/login").
	        	permitAll().
	        	failureUrl("/login?error=true").
	        	loginProcessingUrl("/appLogin").
	        	usernameParameter("app_username").
	        	passwordParameter("app_password").
	        	defaultSuccessUrl("/manage").	
			and().logout().    //logout configuration
				logoutUrl("/appLogout").
				logoutSuccessUrl("/login");
		
		http.csrf().disable();
		
	} 
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("user").password("123qwe").roles("ADMIN");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}	
	
	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}