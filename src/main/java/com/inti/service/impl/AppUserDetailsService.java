package com.inti.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.inti.entities.Role;
import com.inti.entities.Personne;
import com.inti.model.PersonneDetail;
import com.inti.service.interfaces.IPersonneService;

@Service
public class AppUserDetailsService implements UserDetailsService{

	@Autowired
	IPersonneService personneSevice;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Personne personne=personneSevice.findByUsername(username);
		Set<Role> roles=personne.getRoles();
		// les profils
		Set<GrantedAuthority> authorities= new HashSet<GrantedAuthority>();
		
		for(Role role:roles) {
			authorities.add(new SimpleGrantedAuthority(role.getNomRole()));
		}
		
		PersonneDetail usDetail = new PersonneDetail();
		usDetail.setPersonne(personne);
		usDetail.setAuthorities(authorities);
		
		return usDetail;
	}

}
