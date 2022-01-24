package com.inti.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.inti.service.impl.AppUserDetailsService;

@Configuration // quand on lance le projet -> creation bean avec le nom suivant : securityConfig 
@EnableWebSecurity // par défaut web securité désactiver -> donc à activer
public class SecurityConfig extends WebSecurityConfiguration{
	
	@Autowired
	private AppUserDetailsService appUserDetailsService;
	private BCryptPasswordEncoder baBCryptPasswordEncoder;
	

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService).passwordEncoder(baBCryptPasswordEncoder);
	}
	
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().anyRequest().authenticated()
		.and()
		.formLogin().permitAll()
		.and()
		.logout().logoutUrl("/logout").permitAll()
		.and()
		.httpBasic()
		.and()
		.csrf().disable();
	}
}
