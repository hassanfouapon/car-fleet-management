package com.projet.tp.security;

import com.projet.tp.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	private SimpleAuthenticationSuccessHandler successHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {



		http
		.csrf().disable()

		.authorizeRequests()
		.antMatchers(
				"/login",
				"/resources/**",
				"/css/**",
				"/fonts/**", "/images/**","/js/**",
				"/libs/**").permitAll()
		.antMatchers("public/index1","/forgot_password","/reset_password","/seed").permitAll()

		.anyRequest().authenticated()
		.and()
		.formLogin().successHandler(successHandler)
		.loginPage("/login").permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login").permitAll();

	}

	  
  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
	  
	  return new BCryptPasswordEncoder();
	   
	  }
 

	@Autowired
	private UserDetailsService userDetailsService;
	

	@Bean
	public AuthenticationProvider authentication() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		
		return provider;
	}

	 @Bean
	    public UserDetailsService userDetailsService() {
	        return new MyUserDetailsService();
	    }

	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
	         
	        return authProvider;
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }
	
}
