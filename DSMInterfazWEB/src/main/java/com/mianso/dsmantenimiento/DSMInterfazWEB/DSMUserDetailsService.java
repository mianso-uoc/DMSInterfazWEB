package com.mianso.dsmantenimiento.DSMInterfazWEB;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class DSMUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println("########## LOADING USER ##################");
		
		// TODO - LLamada API
		Usuario usuario = new Usuario("mianso", "$2a$12$5x1YwyJiW37Jqp2QY8PNfO2h5SeaW6mRSmy5n3Lz1XKjfUgTRr.5S", "Miren Anso", "mianso@uoc.edu");
		
		return usuario;
	}

}
