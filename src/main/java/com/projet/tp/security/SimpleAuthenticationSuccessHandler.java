package com.projet.tp.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
// Methode permattant de rediriger les utilisateurs selon leur roles vers differents pages d'accueil 

	public void onAuthenticationSuccess(HttpServletRequest arg0, HttpServletResponse arg1, Authentication authentication)
			throws IOException, ServletException {
		
		Collection  <GrantedAuthority> authorities = (Collection<GrantedAuthority>) authentication.getAuthorities();
		authorities.forEach(authority -> {
			if(authority.getAuthority().equals("Admin")) {
				try {
					redirectStrategy.sendRedirect(arg0, arg1, "/");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if(authority.getAuthority().equals("Agent")) {
				try {
					redirectStrategy.sendRedirect(arg0, arg1, "/acceuil_agent");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
	            throw new IllegalStateException();
	        }
		});
		
	}
 
	
}
