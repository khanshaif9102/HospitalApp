package com.shaif.hospital.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Encounter {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int eid;
	private String reason;
	private String dateJoin;
	private String disharge;
	
	@OneToMany(mappedBy="encounters")
	private List<Observation> observations;
	
	@ManyToOne
	@JoinColumn
	private Person persons;
	
	@ManyToOne
	@JoinColumn
	private Branch branches;
	
	@OneToMany(mappedBy="encounters")
	private List<MedOrder> medOrders;

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDateJoin() {
		return dateJoin;
	}

	public void setDateJoin(String dateJoin) {
		this.dateJoin = dateJoin;
	}

	public String getDisharge() {
		return disharge;
	}

	public void setDisharge(String disharge) {
		this.disharge = disharge;
	}

	public List<Observation> getObservations() {
		return observations;
	}

	public void setObservations(List<Observation> observations) {
		this.observations = observations;
	}

	public Person getPersons() {
		return persons;
	}

	public void setPersons(Person persons) {
		this.persons = persons;
	}

	

	public Branch getBranches() {
		return branches;
	}

	public void setBranches(Branch branches) {
		this.branches = branches;
	}

	public List<MedOrder> getMedOrders() {
		return medOrders;
	}

	public void setMedOrders(List<MedOrder> medOrders) {
		this.medOrders = medOrders;
	}
	
	
}
