package com.luciano.felipe.arqpayment.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigure extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>{
	
	private final JwtTokenProvider jwtTokenProvider;

	@Autowired
	public JwtConfigure(JwtTokenProvider jwtTokenProvider) {
		this.jwtTokenProvider = jwtTokenProvider;
	}
	
	@Override
	public void configure(HttpSecurity builder) throws Exception {
		JwtTokenFilter customFilter = new JwtTokenFilter(jwtTokenProvider);
	   builder.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
