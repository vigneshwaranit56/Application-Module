package com.chit.chat.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	
	@Autowired
	UserDetailsService userDetailsService;
	
//	@Autowired
//	private DataSource datasource;


//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//
//		// System.out.println("datasource open Connection" +
//		// dataSource.getConnection("hbstudent", "hbstudent"));
//
//		// auth.jdbcAuthentication().dataSource(dataSource);
//
////		auth.inMemoryAuthentication().withUser("ian").password("{noop}ian").roles("USER");
////
////		auth.inMemoryAuthentication().withUser("dan").password("{noop}dan").roles("USER");
////		auth.inMemoryAuthentication().withUser("chris").password("{noop}chris").roles("USER");
//		
//		auth.userDetailsService(UserService);
//		
//	    auth.jdbcAuthentication().dataSource(datasource)
//
//		 .usersByUsernameQuery("select username,password, enabled from users where username=?")
//	        .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
//	    
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests()
		.anyRequest().authenticated()
		.and().httpBasic()
		.authenticationEntryPoint(authEntryPoint).and().formLogin().loginPage("/login").permitAll().and().logout()
        .permitAll();

	    http.exceptionHandling().accessDeniedPage("/403");

	}
	
	 @Bean
	    public BCryptPasswordEncoder bCryptPasswordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	

    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}
