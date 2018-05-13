package com.krishnas.hms.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="sickness_description")
public class SicknessDescription {
	
	//Annotate class with entity and table

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="description")
	private String description;
	
	@Override
	public String toString() {
		return "SicknessDescription [id=" + id + ", description=" + description + ", symptoms=" + symptoms + "]";
	}

	@Column(name="symptoms")
	private String symptoms;
	
	@OneToOne(mappedBy="sicknessDescription", 
			cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Sickness sickness;
	
	public Sickness getSickness() {
		return sickness;
	}

	public void setSickness(Sickness sickness) {
		this.sickness = sickness;
	}

	public SicknessDescription() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public SicknessDescription(String description, String symptoms) {
		super();
		this.description = description;
		this.symptoms = symptoms;
	}
	
	
	
	//define fields
	
	//Generate constructors, getters and setters along with toString method.
	
	//annotate fields
	
	//and relations along with cascade types

}
