package com.elbon.restful.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
        .csrf().disable()
        .authorizeRequests()
        	.antMatchers("/v2/api-docs/**").permitAll()
        	.antMatchers("/admin/**").hasRole("ADMIN")
        	.anyRequest().authenticated()
        	.and()
        .formLogin();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
			.withUser("user")
				.password("{noop}password")
				.roles("USER")
				.and()
			.withUser("admin")
				.password("{noop}password")
				.roles("ADMIN");
	}
}
