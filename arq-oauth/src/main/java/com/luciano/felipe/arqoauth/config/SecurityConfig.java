package com.luciano.felipe.arqoauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.luciano.felipe.arqoauth.jwt.JwtConfigure;
import com.luciano.felipe.arqoauth.jwt.JwtTokenProvider;

public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	private final JwtTokenProvider jwtTokenProvider;

	@Autowired
	public SecurityConfig(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder () {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder ();
		return bCryptPasswordEncoder;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic().disable()
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
			.authorizeRequests()
			.antMatchers("/login").permitAll()
			.anyRequest().authenticated()
		.and()
		.apply(new JwtConfigure(jwtTokenProvider));
	}
	
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManagerBean();
	}

}
