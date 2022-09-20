package com.mianso.dsmantenimiento.DSMInterfazWEB;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Usuario implements UserDetails {

	private static final long serialVersionUID = 1L;
	
	private String nombreUsuario;
	
	private String pw;
	
	private String nombreCompleto;
	
	private String email;

	public Usuario(String nombreUsuario, String pw, String nombreCompleto, String email) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.pw = pw;
		this.nombreCompleto = nombreCompleto;
		this.email = email;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority> ();
		roles.add(new SimpleGrantedAuthority("USER"));
		System.out.println("ROL USER");
		
		return roles;
	}

	@Override
	public String getPassword() {
		return this.getPw();
	}

	@Override
	public String getUsername() {
		return this.getNombreUsuario();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
