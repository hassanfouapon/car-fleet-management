package com.projet.tp.services;


import com.projet.tp.models.UserPrincipal;
import com.projet.tp.models.entitie.Utilisateur;
import com.projet.tp.repositories.UtilisateurRepository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UtilisateurRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Utilisateur user = userRepository.findByEmail(username);

		if(user==null) {
			throw new UsernameNotFoundException("Utilisateur introuvable!");
		}
		System.out.println(user.toString());
		return new UserPrincipal(user);

	}




}
