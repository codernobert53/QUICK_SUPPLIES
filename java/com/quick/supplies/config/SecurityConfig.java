package com.quick.supplies.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{

	@Autowired
	 public void 
	 configureGlobalSecurity(AuthenticationManagerBuilder auth)
	 throws Exception {
	 
	 auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
	 }
	 
	 @Override
	 protected void configure(HttpSecurity httpSecurity)
	 throws Exception {
	 httpSecurity.formLogin().loginPage("/login")
	           .usernameParameter("userId")
	           .passwordParameter("password");
	 
	 httpSecurity.formLogin()
	               .defaultSuccessUrl("/AdminDashboard")
	               .failureUrl("/login?error");
	 httpSecurity.logout().logoutSuccessUrl("/login?logout");
	 httpSecurity.exceptionHandling().accessDeniedPage("/login?accessDenied");
	 httpSecurity.authorizeRequests()
	               .antMatchers("/").permitAll()
	               .antMatchers("/AdminDashboard").access("hasRole('ADMIN')");
	 httpSecurity.csrf().disable();
	 }

	
}
