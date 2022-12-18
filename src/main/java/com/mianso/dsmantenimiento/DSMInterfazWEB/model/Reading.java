package com.mianso.dsmantenimiento.DSMInterfazWEB.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "reading")
public class Reading {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "date")
	private Date date;
	
	@Column(name = "voltage")
    private float voltage;
    
    @Column(name = "current")
    private float current;
    
    @ManyToOne()
	private Soldadura soldadura;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getVoltage() {
		return voltage;
	}

	public void setVoltage(float voltage) {
		this.voltage = voltage;
	}

	public float getCurrent() {
		return current;
	}

	public void setCurrent(float current) {
		this.current = current;
	}

	public Soldadura getSoldadura() {
		return soldadura;
	}

	public void setSoldadura(Soldadura soldadura) {
		this.soldadura = soldadura;
	}

	@Override
	public String toString() {
		return "Reading [id=" + id + ", date=" + date + ", voltage=" + voltage + ", current=" + current + "]";
	}
    
}
