package com.mianso.dsmantenimiento.DSMInterfazWEB.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OrderBy;

@Entity
@Table(name = "soldadura")
public class Soldadura {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	private Pieza pieza;

	@Column(name = "voltage")
	private float voltage;

	@Column(name = "current")
	private float current;

	@Column(name = "tolerance")
	private int tolerance;

	@OneToMany(mappedBy = "soldadura", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy(clause = "DATE ASC")
	private List<Reading> readings;
	
	@OneToOne(mappedBy = "soldadura", cascade = CascadeType.ALL, orphanRemoval = true)
	private Alarm alarm;

	public Soldadura() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
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

	public int getTolerance() {
		return tolerance;
	}

	public void setTolerance(int tolerance) {
		this.tolerance = tolerance;
	}

	public Alarm getAlarm() {
		return alarm;
	}

	public void setAlarm(Alarm alarm) {
		this.alarm = alarm;
	}

	public List<Reading> getReadings() {
		return readings;
	}

	public void setReadings(List<Reading> readings) {
		this.readings = readings;
	}

	public String getReadingsVAsJson() {
		StringBuilder sb = new StringBuilder("[");

		for (int i = 0; i < readings.size(); i++) {
			Reading reading = readings.get(i);
			sb.append("{\"x\":").append(reading.getDate().getTime()).append(",\"y\":").append(reading.getVoltage()).append("}");

			if (i != readings.size() - 1) {
				sb.append(",");
			}
		}
		sb.append("]");

		return sb.toString();
	}
	
	public String getReadingsIAsJson() {
		StringBuilder sb = new StringBuilder("[");

		for (int i = 0; i < readings.size(); i++) {
			Reading reading = readings.get(i);
			sb.append("{\"x\":").append(reading.getDate().getTime()).append(",\"y\":").append(reading.getCurrent()).append("}");

			if (i != readings.size() - 1) {
				sb.append(",");
			}
		}
		sb.append("]");

		return sb.toString();
	}

	public String getVObjectiveJson() {

		StringBuilder sb = crearJsonValor(voltage);

		return sb.toString();
	}
	
	public String getVLimiteSuperior() {
		
		float limiteSuperior = voltage* (100 + tolerance)/100;
		
		StringBuilder sb = crearJsonValor(limiteSuperior);

		return sb.toString();
	}
	
	public String getVLimiteInferior() {
		
		float limiteInferior = voltage * (100 - tolerance)/100;
		
		StringBuilder sb = crearJsonValor(limiteInferior);

		return sb.toString();
	}
	
	public String getIObjectiveJson() {

		StringBuilder sb = crearJsonValor(current);

		return sb.toString();
	}
	
	public String getILimiteSuperior() {
		
		float limiteSuperior = current* (100 + tolerance)/100;
		
		StringBuilder sb = crearJsonValor(limiteSuperior);

		return sb.toString();
	}
	
	public String getILimiteInferior() {
		
		float limiteInferior = current * (100 - tolerance)/100;
		
		StringBuilder sb = crearJsonValor(limiteInferior);

		return sb.toString();
	}

	private StringBuilder crearJsonValor(float valor) {
		StringBuilder sb = new StringBuilder("[");

		Reading readingInicio = readings.get(0);
		Reading readingFin = readings.get(readings.size() - 1);
		sb.append("{\"x\":")
		.append(readingInicio.getDate().getTime()).append(",\"y\":").append(valor).append("}")
		.append(",").append("{\"x\":")
		.append(readingFin.getDate().getTime()).append(",\"y\":").append(valor).append("}");
		sb.append("]");
		return sb;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + "]";
	}
}
