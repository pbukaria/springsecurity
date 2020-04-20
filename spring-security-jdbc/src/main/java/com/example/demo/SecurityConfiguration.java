package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource datasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()
		 .dataSource(datasource);
		/*.withDefaultSchema()
		.withUser(User.withUsername("user")
				.password("user")
				.roles("USER")
				)
		.withUser(User.withUsername("admin")
				.password("admin")
				.roles("ADMIN")
				);
		*/		
		/*
		 * When having different schema auth.jdbcAuthentication()
		 * .dataSource(datasource)
		 * .usersByUsernameQuery("select username,password,enabled from my_user where username =?"
		 * )
		 * .authoritiesByUsernameQuery("select username,authority from my_auth where username =?"
		 * );
		 */	
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/user").hasAnyRole("USER", "ADMIN")
				.antMatchers("/").permitAll()
				.and().formLogin();
	}
}