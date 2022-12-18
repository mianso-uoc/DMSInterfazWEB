package com.mianso.dsmantenimiento.DSMInterfazWEB.model;

public class UserForm {
	
	private User user;
	
	private Company company;
	
	private String type;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
