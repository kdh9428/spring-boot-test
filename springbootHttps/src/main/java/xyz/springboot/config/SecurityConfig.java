package xyz.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	
//	@Bean
//	public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http	) {
//		http.authorizeExchange().anyExchange().permitAll();
//		return http.build();
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers("/","/hello").permitAll()
//			.anyRequest().fullyAuthenticated()
//			.and()
//			.formLogin()
//			.and()
//			.httpBasic();
//	}
	 @Override
	    protected void configure(HttpSecurity httpSecurity) throws Exception {
	        httpSecurity.authorizeRequests().antMatchers("/").permitAll();
	}
	
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	}
	
}
