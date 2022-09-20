package com.mianso.dsmantenimiento.DSMInterfazWEB.model;

import java.util.Date;
import java.util.Set;

import com.mianso.dsmantenimiento.DSMInterfazWEB.enums.IssueStatus;

public class Issue {

	private long id;

	private String title;
	
	private String description;
	
	private IssueStatus status;
	
	private Date createDate;
	
	private Date closeDate;
	
	private String solution;
	
	private Float totalPrice;
	
    private Set<Machine> machines;
	
//    private List<Comment> comments;
//	
//    private List<Document> documents;
//	
//    private Technician technician;
//	
//    private Company company;
	
	public Issue() {	}

	public Issue(String title, String description) {
		super();
		this.title = title;
		this.description = description;
		this.status = IssueStatus.PENDING;
		this.createDate = new Date();
//		this.technician = technician;
//		this.company = company;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IssueStatus getStatus() {
		return status;
	}

	public void setStatus(IssueStatus status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getCloseDate() {
		return closeDate;
	}

	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public Float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set<Machine> getMachines() {
		return machines;
	}

	public void setMachines(Set<Machine> machines) {
		this.machines = machines;
	}

//	public List<Comment> getComments() {
//		return comments;
//	}
//
//	public void setComments(List<Comment> comments) {
//		this.comments = comments;
//	}
//
//	public List<Document> getDocuments() {
//		return documents;
//	}
//
//	public void setDocuments(List<Document> documents) {
//		this.documents = documents;
//	}
//
//	public Technician getTechnician() {
//		return technician;
//	}
//
//	public void setTechnician(Technician technician) {
//		this.technician = technician;
//	}
//
//	public Company getCompany() {
//		return company;
//	}
//
//	public void setCompany(Company company) {
//		this.company = company;
//	}

	@Override
	public String toString() {
		return "Issue [id=" + id + ", title=" + title + "]";
	}
}
