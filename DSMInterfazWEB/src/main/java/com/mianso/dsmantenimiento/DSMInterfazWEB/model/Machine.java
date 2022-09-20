package com.mianso.dsmantenimiento.DSMInterfazWEB.model;

import java.util.Set;

public class Machine {

	private long id;

	private String serialNumber;
	
//    private Company company;
	
	private Set<Issue> issues;
	
//    private Product product;
	
	public Machine() {	}

	public Machine(String serialNumber) {
		super();
		this.serialNumber = serialNumber;
//		this.company = company;
//		this.product = product;
	}
	
	public Machine(long id, String serialNumber) {
		super();
		this.id = id;
		this.serialNumber = serialNumber;
//		this.company = company;
//		this.product = product;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
//	public Company getCompany() {
//		return company;
//	}
//
//	public void setCompany(Company company) {
//		this.company = company;
//	}

	public Set<Issue> getIssues() {
		return issues;
	}

	public void setIssues(Set<Issue> issues) {
		this.issues = issues;
	}

//	public Product getProduct() {
//		return product;
//	}

//	public void setProduct(Product product) {
//		this.product = product;
//	}

	@Override
	public String toString() {
		return "Machine [id=" + id + ", serialNumber=" + serialNumber + "]";
	}
}
